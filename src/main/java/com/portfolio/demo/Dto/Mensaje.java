package com.portfolio.demo.Dto;

import lombok.Data;

@Data
public class Mensaje {
    private String Mensaje;

    public Mensaje(){

    }
    public Mensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
