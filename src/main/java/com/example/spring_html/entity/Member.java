package com.example.spring_html.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String name;
    private String role;

}
