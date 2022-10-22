package team.one.hhuz.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.one.hhuz.dto.CompanyCreateDto;
import team.one.hhuz.dto.CompanyDto;
import team.one.hhuz.dto.CompanyUpdateDTO;
import team.one.hhuz.service.CompanyService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;


    @PostMapping("/create")
    public ResponseEntity<CompanyDto> create(CompanyCreateDto companyCreateDto) {

        log.info("create method called", companyCreateDto);
        return new ResponseEntity<>(companyService.createCompany(companyCreateDto), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<CompanyDto> get(String name) {
        log.info("get method called", name);
        return new ResponseEntity<>(companyService.get(name), HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<CompanyDto>> getAll(String createBy) {
        log.info("get_all method called", createBy);
        return new ResponseEntity<>(companyService.getAll(createBy), HttpStatus.OK);
    }

    @PostMapping("/updateImg")
    public ResponseEntity<CompanyDto> updateImg(@RequestParam("file") MultipartFile multipartFile, String name) throws IOException {
        log.info("updateImg method called ", multipartFile);
        return new ResponseEntity<>(companyService.updateImg(multipartFile, name), HttpStatus.OK);
    }

    @GetMapping("/getImg")
    public ResponseEntity<byte[]> getImage(String name) {
        log.info("getImg method called");
        return companyService.getImage(name);
    }


    @GetMapping("/get_prefix")
    public ResponseEntity<List<CompanyDto>> getByPrefix(String prefix) {

        return new ResponseEntity<>(companyService.getByPrefix(prefix), HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<CompanyDto> update(CompanyUpdateDTO dto) {

        return new ResponseEntity<>(companyService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delelte")
    public ResponseEntity<Boolean> delete(String name, String createBy) {

        return new ResponseEntity<>(companyService.delete(name, createBy), HttpStatus.OK);
    }


}
