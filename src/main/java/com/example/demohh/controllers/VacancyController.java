package com.example.demohh.controllers;

import com.example.demohh.dtos.vacancy.VacancyCreateDTO;
import com.example.demohh.dtos.vacancy.VacancyDTO;
import com.example.demohh.response.ApiResponse;
import com.example.demohh.services.VacancyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VacancyController extends ApiController<VacancyService> {

    public VacancyController(VacancyService service) {
        super(service);
    }

    @GetMapping(PATH + "/vacancy")
    public ApiResponse<List<VacancyDTO>> getAll() {
        return new ApiResponse<>(service.getAll());
    }

    @GetMapping(PATH + "/vacancy/{id}")
    public ApiResponse<VacancyDTO> get(@PathVariable Long id) {
        return new ApiResponse<>(service.get(id));
    }

    @PostMapping(PATH + "/vacancy")
    public ApiResponse<Void> create(@Valid @RequestBody VacancyCreateDTO dto) {
        service.create(dto);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(201);
    }

    @PostMapping(PATH + "/vacancy/update")
    public ApiResponse<Void> update(@Valid @RequestBody VacancyDTO dto) {
        service.update(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/vacancy/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }


}
