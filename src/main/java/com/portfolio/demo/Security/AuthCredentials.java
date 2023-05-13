package com.portfolio.demo.Security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String name;
    private String email;
    private String password;
}
