package com.company.hhuz.domains.resume;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LanguageType languageType;

    @Column(nullable = false)
    private LanguageLevel level;

    enum LanguageType {
        NATIVE,
        FOREIGN
    }

    enum LanguageLevel {
        A1, A2,
        B1, B2,
        C1, C2
    }
}
