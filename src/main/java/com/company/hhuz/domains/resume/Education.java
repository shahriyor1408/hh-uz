package com.company.hhuz.domains.resume;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String level;
    private String educationalInstitution;
    private String department;
    private String yearOfGraduation;
}
