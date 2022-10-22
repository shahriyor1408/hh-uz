package com.example.demohh.entities;

import com.example.demohh.entities.base.Auditable;
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
public class Vacancy extends Auditable {

    private String title;

    private int salaryFrom;

    private int salaryTo;

    @OneToOne
    private Currency currency;

    private String body;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<KeySkill> keySkills = new ArrayList<>();


}
