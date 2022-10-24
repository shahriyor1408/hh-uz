package com.company.hhuz.services.company;

import com.company.hhuz.domains.Company;
import com.company.hhuz.dtos.CompanyCreateDto;
import com.company.hhuz.dtos.CompanyDto;
import com.company.hhuz.dtos.CompanyUpdateDTO;
import com.company.hhuz.exceptions.AlreadyExistException;
import com.company.hhuz.exceptions.GenericNotFoundException;
import com.company.hhuz.mappers.CompanyMapping;
import com.company.hhuz.repositories.CompanyRepository;
import com.company.hhuz.services.base.BaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService implements BaseService {

    private final CompanyMapping companyMapping;

    private final CompanyRepository companyRepository;

    private final FirebaseService firebaseService;
    @Value("${defaultImage}")
    private String defaultImage;
    private Path root = Paths.get("/home/mick/IdeaProjects/hh_uz/src/main/resources/images");

    public CompanyDto createCompany(CompanyCreateDto companyCreateDto) {
        Company company = companyMapping.fromCreateDto(companyCreateDto);
        Optional<Company> byName = companyRepository.findByName(company.getName());
        if (byName.isPresent()) {
            throw new AlreadyExistException("Bro this company already created please enter other name");
        }
        // todo Optional<User> user = companyRepository.findById(company.getCreatedBy()).orElseThrow(() -> new UserNotFoundException("User not found"));
        company.setCreatedAt(Timestamp.valueOf(LocalDateTime.now(Clock.system(ZoneId.systemDefault())).toString()));
        if (Objects.isNull(company.getLogoImagePath())) {
            company.setLogoImagePath(defaultImage);
        }
        company.setDeleted(false);
        Company save = companyRepository.save(company);
        return companyMapping.toDto(save);
    }

    //    @Cacheable(cacheNames = "companyDto", key = "#name")
    public CompanyDto get(String name) {
        Objects.requireNonNull(name);
        Company company = companyRepository.findByName(name).orElseThrow(() -> new GenericNotFoundException("Company not found"));
        return companyMapping.toDto(company);
    }

    public List<CompanyDto> getAll(String createBy) {
        Objects.requireNonNull(createBy);
        // TODO: 22/10/22 userRepository.findById(createBy).orElseThrow(() -> new GenericNotFoundException("user not found "));
        List<CompanyDto> res = new ArrayList<>();
        companyRepository.findAllByCreatedId(createBy).stream().forEach(i -> res.add(companyMapping.toDto(i)));
        return res;
    }

    //    @Cacheable(cacheNames = "companyDto", key = "#prefix")
    public List<CompanyDto> getByPrefix(@NonNull String prefix) {
        List<Company> foundResult = companyRepository.findByPrefix(prefix.toLowerCase()).orElseThrow(() -> new GenericNotFoundException("Not found result"));
        List<CompanyDto> res = new ArrayList<>();
        foundResult.forEach(i -> res.add(companyMapping.toDto(i)));
        return res;
    }

    //    @CachePut(cacheNames = "companyDto", key = "#dto.name")
    public CompanyDto update(@NonNull CompanyUpdateDTO dto) {
        Company company = companyRepository.findByName(dto.getName()).orElseThrow(() -> new GenericNotFoundException("Company not found"));
        if (!dto.getNewName().isBlank()) {
            company.setName(dto.getNewName());
        }
        if (!dto.getUrl().isBlank()) {
            company.setUrl(dto.getUrl());
        }
        if (!dto.getDescription().isBlank()) {
            company.setDescription(dto.getDescription());
        }
        if (!dto.getLongitude().isBlank()) {
            company.setLongitude(dto.getLongitude());
        }
        if (!dto.getLatitude().isBlank()) {
            company.setLatitude(dto.getLatitude());
        }
        if (!dto.getEmail().isEmpty()) {
            company.setEmail(dto.getEmail());
        }
        if (!dto.getPhone().isEmpty()) {
            company.setPhone(dto.getPhone());
        }
        if (!dto.getLogoImagePath().isBlank()) {
            company.setLogoImagePath(dto.getLogoImagePath());
        }
        companyRepository.saveAndFlush(company);
        return companyMapping.toDto(company);
    }

    //    @CacheEvict(cacheNames = "company", key = "#name")
    public Boolean delete(@NonNull String name, @NonNull String createBy) {
        Company company = companyRepository.findByName(name).orElseThrow(() -> new GenericNotFoundException("Company not found"));
        // TODO: 22/10/22          userRepository.findById(createBy).orElseThrow(() -> new GenericNotFoundException("user not found "));
        companyRepository.markAsDelete(name, createBy);
        return true;
    }

    public CompanyDto updateImg(MultipartFile file, String name) throws IOException {
        Company company = companyRepository.findByName(name).orElseThrow(() -> new GenericNotFoundException("Company not found"));
        company.setLogoImagePath(file.getOriginalFilename());
        String uploads = firebaseService.uploads(file);
        company.setFirebaseName(uploads);
        companyRepository.saveAndFlush(company);
        return companyMapping.toDto(company);
    }

    public ResponseEntity<byte[]> getImage(String name) {
        Company company = companyRepository.findByName(name).orElseThrow(() -> new GenericNotFoundException("Company not found"));
        return firebaseService.download(company.getFirebaseName());
    }
}
