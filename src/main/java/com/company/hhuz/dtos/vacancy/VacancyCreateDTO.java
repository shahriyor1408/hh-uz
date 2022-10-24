package com.company.hhuz.dtos.vacancy;

import com.company.hhuz.dtos.currency.CurrencyDTO;
import com.company.hhuz.dtos.keySkills.KeySkillDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyCreateDTO{
    private String title;
    private int salaryFrom;
    private int salaryTo;
    private CurrencyDTO currency;
    private String body;
    private List<KeySkillDTO> keySkills;
}
