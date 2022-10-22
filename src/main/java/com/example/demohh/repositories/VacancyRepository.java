package com.example.demohh.repositories;

import com.example.demohh.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query(value = "SELECT * FROM vacancy t WHERE t.is_deleted = 0", nativeQuery = true)
    List<Vacancy> getAll ();


}