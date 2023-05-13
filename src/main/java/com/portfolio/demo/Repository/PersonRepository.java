package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findOneByEmail(String email);
}
