package com.company.hhuz.services;

import com.company.hhuz.domains.vacancy.Currency;
import com.company.hhuz.domains.vacancy.KeySkill;
import com.company.hhuz.domains.vacancy.Vacancy;
import com.company.hhuz.dtos.vacancy.VacancyCreateDTO;
import com.company.hhuz.dtos.vacancy.VacancyDTO;
import com.company.hhuz.exceptions.GenericNotFoundException;
import com.company.hhuz.mappers.vacancy.KeySkillsMapper;
import com.company.hhuz.mappers.vacancy.VacancyMapper;
import com.company.hhuz.repositories.CurrencyRepository;
import com.company.hhuz.repositories.KeySkillRepository;
import com.company.hhuz.repositories.VacancyRepository;
import com.company.hhuz.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService implements BaseService {

    private final VacancyRepository repository;
    private final CurrencyRepository currencyRepository;
    private final KeySkillRepository keySkillRepository;
    private final VacancyMapper mapper;
    private final KeySkillsMapper keySkillsMapper;


    public List<VacancyDTO> getAll() {
        return mapper.toDTOs(repository.getAll());
    }

    public void create(VacancyCreateDTO dto) {
        Vacancy vacancy = mapper.fromVacancyCreateDTO(dto);
        vacancy.setCurrency(currencyRepository.getCurrencyByName(dto.getCurrency().getName())
                .orElseThrow(() -> new GenericNotFoundException("Currency not found")));

        List<KeySkill> keySkills = keySkillsMapper.toEntities(dto.getKeySkills());
        keySkillRepository.saveAll(keySkills);

        vacancy.setKeySkills(keySkills);
        repository.save(vacancy);
    }


    public void update(VacancyDTO dto) {
        repository.findById(dto.getId()).orElseThrow(() -> new GenericNotFoundException("Vacancy not found"));
        Currency currency = currencyRepository.getCurrencyByName(dto.getCurrency().getName())
                .orElseThrow(() -> new GenericNotFoundException("Currency not found"));

        Vacancy vacancy = mapper.toEntities(dto);

        List<KeySkill> keySkills = keySkillsMapper.toEntities(dto.getKeySkills());
        keySkillRepository.saveAll(keySkills);

        vacancy.setKeySkills(keySkills);
        vacancy.setCurrency(currency);
        repository.save(vacancy);
    }


    public void delete(Long id) {
        Vacancy vacancy = repository.findById(id).orElseThrow(() -> new GenericNotFoundException("Vacancy not found"));
        vacancy.setDeleted(true);
        repository.save(vacancy);
    }
}
