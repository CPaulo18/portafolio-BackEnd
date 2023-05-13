package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String lastName;
    @NotNull
    private String description;

    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String img;

    public User() {
    }

    public User(String firstName, String lastName, String description, String img) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.img = img;
    }
}



