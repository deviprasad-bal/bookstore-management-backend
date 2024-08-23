package com.devi.bookstore.controller;

import com.devi.bookstore.dto.OrderItemRequest;
import com.devi.bookstore.dto.OrderRequest;
import com.devi.bookstore.model.Orders;
import com.devi.bookstore.service.interfaces.InventoryService;
import com.devi.bookstore.service.interfaces.OrderItemsService;
import com.devi.bookstore.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:5173/")
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    @Autowired
    private OrderItemsService orderItemService;

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/orders")
    public Orders createOrder(@RequestBody OrderRequest orderRequest) {
        Orders order = orderService.createOrder(orderRequest);
        orderItemService.saveOrderItems(order, orderRequest.getItems());

        if ("Accepted".equals(orderRequest.getStatus())) {
            for (OrderItemRequest itemRequest : orderRequest.getItems()) {
                inventoryService.updateInventory(itemRequest.getEditionId(), itemRequest.getQuantity());
            }
        }
        return order;
    }
}
