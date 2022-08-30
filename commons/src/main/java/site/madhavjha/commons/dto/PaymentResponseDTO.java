package site.madhavjha.commons.dto;

import lombok.Data;
import site.madhavjha.commons.enums.PaymentStatus;

import java.util.UUID;

@Data
public class PaymentResponseDTO {
    private Integer userId;
    private UUID orderId;
    private Double amount;
    private PaymentStatus status;
}