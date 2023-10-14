package com.example.spring_html.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 6410450087 Kittikan Makphon
 */

@Configuration
public class ComponentConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
