package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoExperience extends JpaRepository<Experience, Integer> {
    default Optional<Experience> findByNameE(String ignoredExpName) {
        return Optional.empty();
    }

    default boolean existsByNameE(String ignoredExpName) {
        return false;
    }
}
