package com.example.demohh.repositories;

import com.example.demohh.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query(value = "SELECT * FROM vacancy t WHERE t.is_deleted = 0", nativeQuery = true)
    List<Vacancy> getAll ();

    @Query(value = "SELECT * FROM vacancy t WHERE t.is_deleted = 0 and t.id = :id", nativeQuery = true)
    Optional<Vacancy> get(Long id);


}