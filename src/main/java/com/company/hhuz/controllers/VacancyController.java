package com.company.hhuz.controllers;

import com.company.hhuz.dtos.vacancy.VacancyCreateDTO;
import com.company.hhuz.dtos.vacancy.VacancyDTO;
import com.company.hhuz.response.ApiResponse;
import com.company.hhuz.services.VacancyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VacancyController extends ApiController<VacancyService> {

    public VacancyController(VacancyService service) {
        super(service);
    }

    @GetMapping(API + V1 + "/vacancy")
    public ApiResponse<List<VacancyDTO>> getAll() {
        return new ApiResponse<>(service.getAll());
    }

    @PostMapping(API + V1 + "/vacancy")
    public ApiResponse<Void> create(@Valid @RequestBody VacancyCreateDTO dto) {
        service.create(dto);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(201);
    }

    @PostMapping(API + V1 + "/vacancy/update")
    public ApiResponse<Void> update(@Valid @RequestBody VacancyDTO dto) {
        service.update(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(API + V1 + "/vacancy/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }
}
