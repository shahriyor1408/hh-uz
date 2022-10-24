package com.company.hhuz.controllers;


import com.company.hhuz.dtos.CompanyCreateDto;
import com.company.hhuz.dtos.CompanyDto;
import com.company.hhuz.dtos.CompanyUpdateDTO;
import com.company.hhuz.services.company.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class CompanyController extends ApiController<CompanyService> {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    public CompanyController(CompanyService service) {
        super(service);
    }


    @PostMapping(API + V1 + "/company/create")
    public ResponseEntity<CompanyDto> create(CompanyCreateDto companyCreateDto) {

        log.info("create method called {}", companyCreateDto);
        return new ResponseEntity<>(service.createCompany(companyCreateDto), HttpStatus.OK);
    }

    @GetMapping(API + V1 + "/company/get")
    public ResponseEntity<CompanyDto> get(String name) {
        log.info("get method called {}", name);
        return new ResponseEntity<>(service.get(name), HttpStatus.OK);
    }

    @GetMapping(API + V1 + "/company/get_all")
    public ResponseEntity<List<CompanyDto>> getAll(String createBy) {
        log.info("get_all method called {}", createBy);
        return new ResponseEntity<>(service.getAll(createBy), HttpStatus.OK);
    }

    @PostMapping(API + V1 + "/company/updateImg")
    public ResponseEntity<CompanyDto> updateImg(@RequestParam("file") MultipartFile multipartFile, String name) throws IOException {
        log.info("updateImg method called {}", multipartFile);
        return new ResponseEntity<>(service.updateImg(multipartFile, name), HttpStatus.OK);
    }

    @GetMapping(API + V1 + "/company/getImg")
    public ResponseEntity<byte[]> getImage(String name) {
        log.info("getImg method called");
        return service.getImage(name);
    }


    @GetMapping(API + V1 + "/company/get_prefix")
    public ResponseEntity<List<CompanyDto>> getByPrefix(String prefix) {

        return new ResponseEntity<>(service.getByPrefix(prefix), HttpStatus.OK);
    }


    @PutMapping(API + V1 + "/company/update")
    public ResponseEntity<CompanyDto> update(CompanyUpdateDTO dto) {

        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping(API + V1 + "/company/delete")
    public ResponseEntity<Boolean> delete(String name, String createBy) {

        return new ResponseEntity<>(service.delete(name, createBy), HttpStatus.OK);
    }


}
