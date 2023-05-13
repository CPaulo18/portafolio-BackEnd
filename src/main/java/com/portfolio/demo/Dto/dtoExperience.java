package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class dtoExperience {
    @NotBlank
    private String expName;
    @NotBlank
    private String expDesc;

    public dtoExperience() {
    }

    public dtoExperience(String expName, String expDesc) {
        this.expName = expName;
        this.expDesc = expDesc;
    }
}
