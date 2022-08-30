package site.madhavjha.orderservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import site.madhavjha.commons.enums.OrderStatus;

import java.util.UUID;

@Data
public class PurchaseOrder {

    @Id
    private UUID id;
    private Integer userId;
    private Integer productId;
    private Double price;
    private OrderStatus status;

}