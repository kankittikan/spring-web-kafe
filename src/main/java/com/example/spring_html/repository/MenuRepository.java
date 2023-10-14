package com.example.spring_html.repository;

import com.example.spring_html.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

public interface MenuRepository extends JpaRepository<Menu, UUID> {
}
