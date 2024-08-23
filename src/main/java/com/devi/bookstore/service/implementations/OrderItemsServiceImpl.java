package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.OrderItemsDAO;
import com.devi.bookstore.dto.OrderItemRequest;
import com.devi.bookstore.model.Inventory;
import com.devi.bookstore.model.OrderItems;
import com.devi.bookstore.model.Orders;
import com.devi.bookstore.repository.InventoryRepository;
import com.devi.bookstore.service.interfaces.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsDAO orderItemsDAO;

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public void saveOrderItems(Orders order, List<OrderItemRequest> orderItemRequests) {
        for (OrderItemRequest itemRequest : orderItemRequests) {
            OrderItems orderItem = new OrderItems();

            Inventory inventory = inventoryRepository.findById(itemRequest.getEditionId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid edition ID: " + itemRequest.getEditionId()));

            orderItem.setInventory(inventory);
            orderItem.setOrders(order);
            orderItem.setPrice(itemRequest.getPrice());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setValue(itemRequest.getValue());
            orderItemsDAO.saveOrderItem(orderItem);
        }
    }
}
