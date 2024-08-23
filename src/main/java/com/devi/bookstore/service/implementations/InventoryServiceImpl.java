package com.devi.bookstore.service.implementations;

import com.devi.bookstore.exception.ResourceNotFoundException;
import com.devi.bookstore.model.Inventory;
import com.devi.bookstore.repository.InventoryRepository;
import com.devi.bookstore.service.interfaces.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    @Override
    public void updateInventory(int editionId, int quantityBought) {
        Inventory inventory = inventoryRepository.findByEditionId(editionId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for edition ID: " + editionId));

        inventory.setTotalStocks(inventory.getTotalStocks() - quantityBought);
        inventory.setSoldStocks(inventory.getSoldStocks() + quantityBought);

        inventoryRepository.save(inventory);
    }
}
