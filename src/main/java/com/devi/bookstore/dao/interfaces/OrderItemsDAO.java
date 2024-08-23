package com.devi.bookstore.dao.interfaces;

import com.devi.bookstore.model.OrderItems;

public interface OrderItemsDAO {
    OrderItems saveOrderItem(OrderItems orderItem);
}
