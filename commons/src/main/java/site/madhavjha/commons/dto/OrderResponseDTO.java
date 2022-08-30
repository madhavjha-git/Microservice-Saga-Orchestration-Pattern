package site.madhavjha.commons.dto;

import lombok.Data;
import site.madhavjha.commons.enums.OrderStatus;

import java.util.UUID;

@Data
public class OrderResponseDTO {

    private UUID orderId;
    private Integer userId;
    private Integer productId;
    private Double amount;
    private OrderStatus status;

}