package com.company.hhuz.repositories;

import com.company.hhuz.domains.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("from Company  c  where c.isDeleted=false and  lower(c.name) like :name ")
    Optional<Company> findByName(@Param(value = "name") String name);

    @Query("from Company  c where c.isDeleted=false  and c.createdBy = :createdBy")
    List<Company> findAllByCreatedId(@Param(value = "createdBy") String createBy);

    @Query("from Company  c where c.isDeleted=false  and lower(c.name) like  %:prefix%")
    Optional<List<Company>> findByPrefix(@Param(value = "prefix") String prefix);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Company c set c.isDeleted=true where c.name like :name and c.createdBy = :by")
    void markAsDelete(@Param(value = "name") String name, @Param(value = "name") String by);
}
