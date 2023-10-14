package com.example.spring_html.service;

import com.example.spring_html.common.Status;
import com.example.spring_html.entity.Menu;
import com.example.spring_html.entity.OrderItem;
import com.example.spring_html.entity.OrderItemKey;
import com.example.spring_html.entity.PurchaseOrder;
import com.example.spring_html.model.AddCartRequest;
import com.example.spring_html.repository.MenuRepository;
import com.example.spring_html.repository.OrderItemRepository;
import com.example.spring_html.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

@Service
public class OrderService {


    @Autowired
    private PurchaseOrderRepository orderRepository;

    @Autowired
    private OrderItemRepository itemRepository;


    @Autowired
    private MenuRepository menuRepository;


    private UUID currentOrderId;


    public void createNewOrder() {
        PurchaseOrder newOrder = new PurchaseOrder();
        newOrder.setStatus(Status.ORDER);
        PurchaseOrder record = orderRepository.save(newOrder);
        currentOrderId = record.getId();
    }

    public void order(UUID menuId, AddCartRequest request) {
        if (currentOrderId == null)
            createNewOrder();

        PurchaseOrder currentOrder =
                orderRepository.findById(currentOrderId).get();
        Menu menu = menuRepository.findById(menuId).get();

        OrderItem item = new OrderItem();
        item.setId(new OrderItemKey(currentOrderId, menuId));
        item.setPurchaseOrder(currentOrder);
        item.setMenu(menu);
        item.setQuantity(request.getQuantity());
        itemRepository.save(item);
    }

    public PurchaseOrder getCurrentOrder() {
        if (currentOrderId == null)
            createNewOrder();
        return orderRepository.findById(currentOrderId).get();
    }

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }


    public void submitOrder() {
        PurchaseOrder currentOrder =
                orderRepository.findById(currentOrderId).get();
        currentOrder.setTimestamp(LocalDateTime.now());
        currentOrder.setStatus(Status.CONFIRM);
        orderRepository.save(currentOrder);
        currentOrderId = null;
    }

    public PurchaseOrder getById(UUID id) {
        return orderRepository.findById(id).get();
    }


    public void finishOrder(UUID orderId) {
        PurchaseOrder record = orderRepository.findById(orderId).get();
        record.setStatus(Status.FINISH);
        orderRepository.save(record);
    }


}

