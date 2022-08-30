package site.madhavjha.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.madhavjha.commons.dto.OrderRequestDTO;
import site.madhavjha.commons.dto.OrderResponseDTO;
import site.madhavjha.orderservice.entity.PurchaseOrder;
import site.madhavjha.orderservice.entity.TestDTO;
import site.madhavjha.orderservice.service.OrderService;

import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/test")
    public Mono<String> test(@RequestBody Mono<TestDTO> mono) {
        log.info("This is Test end point");
        return Mono.just("Hello").delayElement(Duration.ofSeconds(1));
    }

    @PostMapping("/create")
    public Mono<PurchaseOrder> createOrder(@RequestBody Mono<OrderRequestDTO> mono) {
        log.info("Creating order");
        return mono
                .flatMap(this.service::createOrder);
    }

    @GetMapping("/all")
    public Flux<OrderResponseDTO> getOrders() {
        return this.service.getAll();
    }

}