package com.company.hhuz.domains.resume;

import com.company.hhuz.domains.Auditable;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Resume extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String mobilePhone;

    @Column(nullable = false)
    private String currentCity;

    @Column(nullable = false)
    private Timestamp dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String citizenship;

    @Column(nullable = false)
    @OneToMany
    private List<WorkExperience> workExperience;

    @OneToMany
    private List<Education> education;
    private String career;
    private String salary;

    enum Gender {
        MALE,
        FEMALE
    }
}
