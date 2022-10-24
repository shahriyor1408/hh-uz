package com.company.hhuz.mappers.vacancy;

import com.company.hhuz.domains.vacancy.Vacancy;
import com.company.hhuz.dtos.vacancy.VacancyCreateDTO;
import com.company.hhuz.dtos.vacancy.VacancyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyMapper {

    Vacancy fromVacancyCreateDTO(VacancyCreateDTO createDTO);

    VacancyDTO toDTO(Vacancy entity);

    Vacancy toEntities(VacancyDTO dto);

    List<VacancyDTO> toDTOs(List<Vacancy> entities);
}
