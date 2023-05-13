package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class dtoSkill {
    @NotBlank
    private String skillName;
    @NotBlank
    private Integer porcent;

    public dtoSkill() {
    }

    public dtoSkill(String skillName, Integer porcent) {
        this.skillName = skillName;
        this.porcent = porcent;
    }
}
