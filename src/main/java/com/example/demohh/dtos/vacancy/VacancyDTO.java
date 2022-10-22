package com.example.demohh.dtos.vacancy;

import com.example.demohh.dtos.currency.CurrencyDTO;
import com.example.demohh.dtos.keySkills.KeySkillDTO;
import com.example.demohh.entities.Currency;
import com.example.demohh.entities.KeySkill;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDTO {
    private long id;
    private String title;
    private int salaryFrom;
    private int salaryTo;
    private CurrencyDTO currency;
    private String body;
    private List<KeySkillDTO> keySkills;

}