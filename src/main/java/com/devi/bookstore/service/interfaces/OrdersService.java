package com.devi.bookstore.service.interfaces;

import com.devi.bookstore.dto.OrderRequest;
import com.devi.bookstore.model.Orders;

public interface OrdersService {
    Orders createOrder(OrderRequest orderRequest);
}
