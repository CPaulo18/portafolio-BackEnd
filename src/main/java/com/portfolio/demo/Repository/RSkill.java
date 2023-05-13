package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RSkill extends JpaRepository<Skill, Integer> {
    default Optional<Skill> findByNameS(String skillName) {
        return null;
    }

    default boolean existsByNameS(String skillName) {
        return false;
    }
}
