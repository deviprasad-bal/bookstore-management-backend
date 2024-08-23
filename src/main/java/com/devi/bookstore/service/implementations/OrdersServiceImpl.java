package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.OrdersDAO;
import com.devi.bookstore.dto.OrderRequest;
import com.devi.bookstore.model.Orders;
import com.devi.bookstore.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;

    @Transactional
    @Override
    public Orders createOrder(OrderRequest orderRequest) {
        Orders order = new Orders();
        order.setTotal(orderRequest.getTotal());
        order.setDate(LocalDateTime.now());
        order.setOrderStatus(orderRequest.getStatus());
        return ordersDAO.saveOrder(order);
    }
}
