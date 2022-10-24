package com.company.hhuz.domains.resume;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String placeOfWork;

    @Column(nullable = false)
    private String aboutMySelf;

    @OneToMany
    private List<Skill> keySkills;
}
