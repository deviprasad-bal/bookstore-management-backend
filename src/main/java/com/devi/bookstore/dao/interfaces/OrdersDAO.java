package com.devi.bookstore.dao.interfaces;

import com.devi.bookstore.model.Orders;

public interface OrdersDAO {
    Orders saveOrder(Orders order);
}
