package com.example.spring_html.model;

import lombok.Data;

import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

@Data
public class MenuRequest {
    private String name;
    private String price;
    private UUID categoryId;

}