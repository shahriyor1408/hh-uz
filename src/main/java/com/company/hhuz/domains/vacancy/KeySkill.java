package com.company.hhuz.domains.vacancy;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class KeySkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "keySkills")
//    private Collection<Vacancy> vacancies = new ArrayList<>();

}
