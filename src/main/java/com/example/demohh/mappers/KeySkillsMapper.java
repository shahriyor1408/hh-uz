package com.example.demohh.mappers;

import com.example.demohh.dtos.keySkills.KeySkillCreateDTO;
import com.example.demohh.dtos.keySkills.KeySkillDTO;
import com.example.demohh.dtos.vacancy.VacancyCreateDTO;
import com.example.demohh.dtos.vacancy.VacancyDTO;
import com.example.demohh.entities.KeySkill;
import com.example.demohh.entities.Vacancy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeySkillsMapper {

    KeySkill fromKeySkillCreateDTO(KeySkillCreateDTO createDTO);

    KeySkillDTO toDTO(KeySkill entity);

    List<KeySkillDTO> toDTOs(List<KeySkill> entities);

    List<KeySkill> toEntities(List<KeySkillDTO> dtos);
}
