package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skillName;
    private int porcent;

    public Skill() {
    }

    public Skill(String skillName, int porcent) {
        this.skillName = skillName;
        this.porcent = porcent;
    }
}
