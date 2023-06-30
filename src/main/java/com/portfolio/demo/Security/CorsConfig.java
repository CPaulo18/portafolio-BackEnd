package com.portfolio.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login")
                        .allowedOrigins("https://frontendap-65c03.web.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .exposedHeaders("*");

                registry.addMapping("/**")
                        .allowedOrigins("https://frontendap-65c03.web.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
