package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RExperience extends JpaRepository<Experience, Integer> {
    default Optional<Experience> findByNameE(String expName) {
        return null;
    }

    default boolean existsByNameE(String expName) {
        return false;
    }
}
