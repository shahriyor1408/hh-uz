package com.company.hhuz.repositories;

import com.company.hhuz.domains.vacancy.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> getCurrencyByName(String name);
}