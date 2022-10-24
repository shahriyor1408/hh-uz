package com.company.hhuz.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
@Getter
public class CompanyDto implements Serializable {
    private String name;
    private String logoImagePath;
    private List<String> phone;
    private List<String> email;
    private String latitude;
    private String longitude;
    private String url;
    private String description;

    private String createdBy;
    private String createdAt;

}
