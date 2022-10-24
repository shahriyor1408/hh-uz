package com.company.hhuz.controllers;

import com.company.hhuz.dtos.auth.RegisterDTO;
import com.company.hhuz.response.ApiResponse;
import com.company.hhuz.services.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController extends ApiController<AuthService>{


    public AuthController(AuthService service) {
        super(service);
    }

    @PostMapping(API + V1 + "auth/register")
    public HttpEntity<?> registerUser( @Valid @RequestBody RegisterDTO registerDTO) {
        ApiResponse<Void> apiResponse = service.registerUser(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
