package com.company.hhuz.domains.vacancy;

import com.company.hhuz.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
