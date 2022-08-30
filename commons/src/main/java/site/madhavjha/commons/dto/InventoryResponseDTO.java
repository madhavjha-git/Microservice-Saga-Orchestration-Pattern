package site.madhavjha.commons.dto;

import lombok.Data;
import site.madhavjha.commons.enums.InventoryStatus;

import java.util.UUID;

@Data
public class InventoryResponseDTO {

    private UUID orderId;
    private Integer userId;
    private Integer productId;
    private InventoryStatus status;

}