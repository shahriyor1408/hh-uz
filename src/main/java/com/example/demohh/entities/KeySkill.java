package com.example.demohh.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
