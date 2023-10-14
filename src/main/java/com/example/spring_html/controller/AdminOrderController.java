package com.example.spring_html.controller;

import com.example.spring_html.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-all";
    }

    @GetMapping("/{orderId}")
    public String getAllOrders(@PathVariable UUID orderId, Model model) {
        model.addAttribute("order", orderService.getById(orderId));
        return "order-view";
    }


    @PostMapping("/{orderId}/finish")
    public String finishOrder(@PathVariable UUID orderId, Model model) {
        orderService.finishOrder(orderId);
        return "redirect:/admin/orders";

    }
}
