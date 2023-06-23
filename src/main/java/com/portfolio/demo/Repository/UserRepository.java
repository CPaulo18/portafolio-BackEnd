package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    default Optional<User> findByNameU(String firstName) {
        return null;
    }

    default boolean existsByNameU(String name) {
        return false;
    }
}
