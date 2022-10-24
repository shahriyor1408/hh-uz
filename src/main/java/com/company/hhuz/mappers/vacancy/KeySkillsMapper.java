package com.company.hhuz.mappers.vacancy;

import com.company.hhuz.domains.vacancy.KeySkill;
import com.company.hhuz.dtos.keySkills.KeySkillCreateDTO;
import com.company.hhuz.dtos.keySkills.KeySkillDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeySkillsMapper {

    KeySkill fromKeySkillCreateDTO(KeySkillCreateDTO createDTO);

    KeySkillDTO toDTO(KeySkill entity);

    List<KeySkillDTO> toDTOs(List<KeySkill> entities);

    List<KeySkill> toEntities(List<KeySkillDTO> dtos);
}
