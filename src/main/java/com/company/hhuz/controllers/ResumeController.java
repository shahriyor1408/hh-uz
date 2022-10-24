package com.company.hhuz.controllers;

import com.company.hhuz.dtos.resume.ResumeCreateDto;
import com.company.hhuz.dtos.resume.ResumeDetails;
import com.company.hhuz.dtos.resume.ResumeUpdateDto;
import com.company.hhuz.services.resume.ResumeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ResumeController extends ApiController<ResumeService> {

    public ResumeController(ResumeService service) {
        super(service);
    }

    @PostMapping(API + V1 + "/resume/create")
    public ResponseEntity<Long> create(@RequestBody @Valid ResumeCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping(API + V1 + "/resume/get/{id}")
    public ResponseEntity<ResumeDetails> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(API + V1 + "/resume/getAll/{userId}")
    public ResponseEntity<List<ResumeDetails>> getAll(@PathVariable Long userId) {
        return service.getAll(userId);
    }

    @PutMapping(API + V1 + "/resume/update")
    public ResponseEntity<ResumeDetails> update(@RequestBody @Valid ResumeUpdateDto dto) {
        return service.update(dto);
    }

    @DeleteMapping(API + V1 + "/resume/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
