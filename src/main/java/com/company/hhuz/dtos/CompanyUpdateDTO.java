package com.company.hhuz.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyUpdateDTO {
    @NotBlank
    private String name;

    private String newName;
    private List<String> email;
    private List<String> phone;
    private String latitude;
    private String longitude;

    private String url;
    private String description;
    private String logoImagePath;


}
