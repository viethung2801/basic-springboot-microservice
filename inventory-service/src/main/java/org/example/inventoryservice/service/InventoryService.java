package org.example.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventoryservice.dto.InventoryResponse;
import org.example.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HungDV
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {
//       log.info("Wait started");
//       Thread.sleep(10000);
//       log.info("Wait ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory -> InventoryResponse.builder()
               .skuCode(inventory.getSkuCode())
               .isInStock(inventory.getQuantity() > 0)
               .build()).toList();

    }
}
