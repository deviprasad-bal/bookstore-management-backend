package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.OrderItemsDAO;
import com.devi.bookstore.model.OrderItems;
import com.devi.bookstore.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemsDAOImpl implements OrderItemsDAO {

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItems saveOrderItem(OrderItems orderItem) {
        return orderItemsRepository.save(orderItem);
    }
}
