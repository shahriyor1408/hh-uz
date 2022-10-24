package com.company.hhuz.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mapstruct.control.NoComplexMapping;

import java.util.List;

@AllArgsConstructor
@NoComplexMapping
@Getter
@Setter
@ToString
public class CompanyCreateDto {
    private String name;
    private String logoImagePath;

    private List<String> phone;

    private List<String> email;


    private String latitude;
    private String longitude;
    private String url;
    private String description;
    private String createdBy;
}
