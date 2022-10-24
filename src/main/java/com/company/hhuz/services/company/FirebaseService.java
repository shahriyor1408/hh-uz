package com.company.hhuz.services.company;

import com.company.hhuz.services.base.BaseService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FirebaseService implements BaseService {
    File file = new File("/home/shahriyor/IdeaProjects/hh-uz/src/main/resources/hh-uz.json");

    private final Path root = Paths.get("/home/mick/IdeaProjects/hh_uz/src/main/resources/images");
    private Storage storage;
    String name = "/home/shahriyor/IdeaProjects/hh-uz/src/main/resources/hh-uz.json";

    @PostConstruct
    public void init() {
        try {

            FileInputStream serviceAccount = new FileInputStream(name);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setProjectId("asliddinbek-project")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String uploads(MultipartFile file) throws IOException {
        String newFilename = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        BlobId blobId = BlobId.of("hh-uz-4951c.appspot.com", newFilename);


        Map<String, String> metaData;
        metaData = new HashMap<>();
        metaData.put("originalName", file.getOriginalFilename());
        metaData.put("contentType", file.getContentType());
        metaData.put("size", "" + file.getSize());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .setMetadata(metaData)
                .build();
        storage.create(blobInfo, file.getInputStream().readAllBytes());
        return newFilename;
    }

    @EventListener
    public void init(ApplicationReadyEvent applicationReadyEvent) {
        try {
            InputStream serviceAccount = new FileInputStream(name);
            storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("hh-uz-4951c")
                    .build().getService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResponseEntity<byte[]> download(String filename) {
        BlobId blobId = BlobId.of("hh-uz-4951c.appspot.com", filename);

        Blob blob = storage.get(blobId);
        Map<String, String> metadata = blob.getMetadata();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = " + metadata.get("originalName"))
                .contentLength(Long.parseLong(metadata.get("size")))
                .contentType(MediaType.parseMediaType(metadata.get("contentType")))
                .body(blob.getContent());
    }
}
