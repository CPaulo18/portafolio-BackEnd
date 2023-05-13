package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eduName;
    private String eduDesc;

    public Education(){}

    public Education(String eduName, String eduDesc) {
        this.eduName = eduName;
        this.eduDesc = eduDesc;
    }
}
