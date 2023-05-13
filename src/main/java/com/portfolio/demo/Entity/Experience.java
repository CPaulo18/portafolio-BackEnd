package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expName;
    private String expDesc;

    public Experience(){}

    public Experience(String expName, String expDesc){
        this.expName = expName;
        this.expDesc = expDesc;
    }
}
