package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long>{
    
    public List<Domain> findByIdGreaterThan(double min); //derivedQuery

    void delete(Domain domain);
   /*  @Query("SELECT e FROM Domain e WHERE e.domain_id > ?1 And e.domain_id < ?2")
    public List<Domain> findByIdInRange(double min, double max); */

}
