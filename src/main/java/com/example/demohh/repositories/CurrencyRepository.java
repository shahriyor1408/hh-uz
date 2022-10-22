package com.example.demohh.repositories;

import com.example.demohh.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> getCurrencyByName(String name);
}