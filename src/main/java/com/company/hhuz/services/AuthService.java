package com.company.hhuz.services;

import com.company.hhuz.domains.user.AuthUser;
import com.company.hhuz.domains.user.AuthUserRole;
import com.company.hhuz.dtos.auth.RegisterDTO;
import com.company.hhuz.exceptions.AlreadyExistException;
import com.company.hhuz.repositories.UserRepository;
import com.company.hhuz.response.ApiResponse;
import com.company.hhuz.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService, BaseService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender javaMailSender;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return null;
    }

    public ApiResponse<Void> registerUser(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail()))
            throw new AlreadyExistException("Email is already exist!");
        AuthUser authUser = new AuthUser(registerDTO.getFullName(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()),
                AuthUserRole.USER);
        int code = new Random().nextInt(999999);
        System.out.println(code);
        authUser.setEmailCode(String.valueOf(code).substring(0, 4));
        userRepository.save(authUser);
        sendEmail(authUser.getEmail(), authUser.getEmailCode());
        return new ApiResponse<>(200);
    }

    public boolean sendEmail(String sendingEmail, String emailCode) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("axmatov0113@gmail.com");
            message.setTo(sendingEmail);
            message.setSubject("Head Hunter verification code");
            message.setText(emailCode);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
