package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Simple;

public interface SimpleRepository extends JpaRepository <Simple, Long> {
    
}
