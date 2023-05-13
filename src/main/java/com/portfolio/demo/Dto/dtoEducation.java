package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class dtoEducation {
    @NotBlank
    private String eduName;
    @NotBlank
    private String eduDesc;

    public dtoEducation(String eduName, String eduDesc) {
        this.eduName = eduName;
        this.eduDesc = eduDesc;
    }
}
