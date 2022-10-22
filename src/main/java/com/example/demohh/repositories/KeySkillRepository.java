package com.example.demohh.repositories;

import com.example.demohh.entities.KeySkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeySkillRepository extends JpaRepository<KeySkill, Long> {
}