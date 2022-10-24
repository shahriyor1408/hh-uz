package com.company.hhuz.domains;

import lombok.*;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Company extends Auditable {
    private String name;
    private String logoImagePath;
    private String firebaseName;

    @ElementCollection
    @CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "phone")
    private List<String> phone;

    @ElementCollection
    @CollectionTable(name = "emails", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "email")
    private List<String> email;


    private String latitude;
    private String longitude;
    private String url;
    private String description;

// TODO: 22/10/22    add many to one with   vacancy
// TODO: 22/10/22    add many to one with   user for followers


}
