package com.company.hhuz.dtos.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotNull
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    private String password;

}
