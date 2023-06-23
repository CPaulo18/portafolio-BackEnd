package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoSkill extends JpaRepository<Skill, Integer> {
    default Optional<Skill> findByNameS(String ignoredSkillName) {
        return Optional.empty();
    }

    default boolean existsByNameS(String ignoredSkillName) {
        return false;
    }
}
