package com.example.demohh.mappers;

import com.example.demohh.dtos.vacancy.VacancyCreateDTO;
import com.example.demohh.dtos.vacancy.VacancyDTO;
import com.example.demohh.entities.Vacancy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyMapper {

    Vacancy fromVacancyCreateDTO(VacancyCreateDTO createDTO);

    VacancyDTO toDTO(Vacancy entity);

    List<VacancyDTO> toDTOs(List<Vacancy> entities);
}
