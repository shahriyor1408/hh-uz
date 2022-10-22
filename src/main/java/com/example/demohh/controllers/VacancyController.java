package com.example.demohh.controllers;

import com.example.demohh.dtos.vacancy.VacancyCreateDTO;
import com.example.demohh.dtos.vacancy.VacancyDTO;
import com.example.demohh.dtos.vacancy.VacancyUpdateDTO;
import com.example.demohh.response.ApiResponse;
import com.example.demohh.services.VacancyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
