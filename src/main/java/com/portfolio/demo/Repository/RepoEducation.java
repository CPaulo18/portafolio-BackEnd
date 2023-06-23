package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoEducation extends JpaRepository<Education, Integer> {
    default Optional<Education> findByNameE(String eduName){
        return null;
    }

    default boolean existsByNameE(String eduName){
        return false;
    }
}
