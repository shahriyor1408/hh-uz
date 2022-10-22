package team.one.hhuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.one.hhuz.domain.Company;
import team.one.hhuz.dto.CompanyDto;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, String> {


    @Query("select c from Company  c  where c.isDelete=false and  lower(c.name) like lower(?1) ")
    Optional<Company> findByName(String name);

    @Query("select c from Company  c where c.isDelete=false  and c.createdBy like ?1")
    List<Company> findAllByCreatedId(String createBy);

    @Query("select c from Company  c where c.isDelete=false  and lower(c.name) like  %:prefix%")
    Optional<List<Company>> findByPrefix(String prefix);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Company c  set c.isDelete=true where c.name like :name and c.createdBy like :by")
    void markAsDelete(String name,String by);
}
