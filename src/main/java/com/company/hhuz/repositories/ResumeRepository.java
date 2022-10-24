package com.company.hhuz.repositories;

import com.company.hhuz.domains.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
