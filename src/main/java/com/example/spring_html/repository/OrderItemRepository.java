package com.example.spring_html.repository;

import com.example.spring_html.entity.OrderItem;
import com.example.spring_html.entity.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 6410450087 Kittikan Makphon
 */

@Repository
public interface OrderItemRepository
        extends JpaRepository<OrderItem, OrderItemKey> {
}
