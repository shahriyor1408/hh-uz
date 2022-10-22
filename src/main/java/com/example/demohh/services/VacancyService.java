package com.example.demohh.services;

import com.example.demohh.dtos.vacancy.VacancyCreateDTO;
import com.example.demohh.dtos.vacancy.VacancyDTO;
import com.example.demohh.entities.Currency;
import com.example.demohh.entities.KeySkill;
import com.example.demohh.entities.Vacancy;
import com.example.demohh.exceptions.GenericNotFoundException;
import com.example.demohh.mappers.KeySkillsMapper;
import com.example.demohh.mappers.VacancyMapper;
import com.example.demohh.repositories.CurrencyRepository;
import com.example.demohh.repositories.KeySkillRepository;
import com.example.demohh.repositories.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository repository;
    private final CurrencyRepository currencyRepository;
    private final KeySkillRepository keySkillRepository;
    private final VacancyMapper mapper;
    private final KeySkillsMapper keySkillsMapper;


    public List<VacancyDTO> getAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public void create(VacancyCreateDTO dto) {
        Vacancy vacancy = mapper.fromVacancyCreateDTO(dto);

        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Currency not found", 404);
        vacancy.setCurrency(currencyRepository.getCurrencyByName(dto.getCurrency().getName()).orElseThrow(notFoundException));

        List<KeySkill> keySkills = keySkillsMapper.toEntities(dto.getKeySkills());
        keySkillRepository.saveAll(keySkills);
        vacancy.setKeySkills(keySkills);

        repository.save(vacancy);
    }


}
