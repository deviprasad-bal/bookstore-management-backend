package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.OrdersDAO;
import com.devi.bookstore.model.Orders;
import com.devi.bookstore.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }
}
