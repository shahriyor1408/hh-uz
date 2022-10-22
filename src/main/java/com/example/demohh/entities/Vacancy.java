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
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private int salaryFrom;

    private int salaryTo;

    @OneToOne
    private Currency currency;

    private String body;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<KeySkill> keySkills = new ArrayList<>();


}
