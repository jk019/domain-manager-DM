package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.zhaw.springboot.entities.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {
    @Query("SELECT e FROM Element e WHERE e.name = :name")
    List<Element> findAllByName(@Param("name") String name);
}
