package com.devi.bookstore.service.interfaces;

import com.devi.bookstore.dto.OrderItemRequest;
import com.devi.bookstore.model.Orders;

import java.util.List;

public interface OrderItemsService {
    void saveOrderItems(Orders order, List<OrderItemRequest> orderItemRequests);
}
