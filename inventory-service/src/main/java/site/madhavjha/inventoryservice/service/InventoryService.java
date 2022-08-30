package site.madhavjha.inventoryservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.madhavjha.commons.dto.InventoryRequestDTO;
import site.madhavjha.commons.dto.InventoryResponseDTO;
import site.madhavjha.commons.enums.InventoryStatus;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class InventoryService {

    private Map<Integer, Integer> productInventoryMap;

    @PostConstruct
    private void init(){
        this.productInventoryMap = new HashMap<>();
        this.productInventoryMap.put(1, 5);
        this.productInventoryMap.put(2, 5);
        this.productInventoryMap.put(3, 5);
    }

    public InventoryResponseDTO deductInventory(final InventoryRequestDTO requestDTO){
        int quantity = this.productInventoryMap.getOrDefault(requestDTO.getProductId(), 0);
        log.info("Before deduct : Current Stock for productId : {} is {}", requestDTO.getProductId(),quantity);
        InventoryResponseDTO responseDTO = new InventoryResponseDTO();
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setProductId(requestDTO.getProductId());
        responseDTO.setStatus(InventoryStatus.UNAVAILABLE);
        if(quantity > 0){
            responseDTO.setStatus(InventoryStatus.AVAILABLE);
            this.productInventoryMap.put(requestDTO.getProductId(), quantity - 1);
        }
        log.info("Response from inventory : {}",responseDTO);
        return responseDTO;
    }

    public void addInventory(final InventoryRequestDTO requestDTO){
        this.productInventoryMap
                .computeIfPresent(requestDTO.getProductId(), (k, v) -> v + 1);
        log.info("Adding back - Current Stock for productId : {} is {}", requestDTO.getProductId(),this.productInventoryMap.getOrDefault(requestDTO.getProductId(), 0));
    }

}