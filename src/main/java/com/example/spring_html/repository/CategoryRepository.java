package com.example.spring_html.repository;

import com.example.spring_html.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
