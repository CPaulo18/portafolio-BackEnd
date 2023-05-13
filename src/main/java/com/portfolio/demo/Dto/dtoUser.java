package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class dtoUser {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String description;
    @NotBlank
    private String img;

    public dtoUser() {
    }

    public dtoUser(String firstName, String lastName, String description, String img) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.img = img;
    }
}
