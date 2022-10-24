package com.company.hhuz.dtos.resume;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeCreateDto {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Surname is required!")
    private String surname;

    @NotBlank(message = "Mobile phone is required!")
    private String mobilePhone;

    @NotBlank(message = "City required!")
    private String currentCity;
}
