package com.company.hhuz.repositories;

import com.company.hhuz.domains.user.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AuthUser, Long> {
    boolean existsByEmail(String email);

}
