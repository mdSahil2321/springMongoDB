package com.example.springmongodb.controller;

import com.example.springmongodb.document.OrderLifecycleDocument;
import com.example.springmongodb.service.OrderLifecycleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderLifecycleController {

    private final OrderLifecycleService service;

    public OrderLifecycleController(OrderLifecycleService service) {
        this.service = service;
    }

    // Create a new order
    @PostMapping("/{orderId}")
    public OrderLifecycleDocument createOrder(@PathVariable String orderId) {
        return service.createOrder(orderId);
    }

    // Add event to order
    @PostMapping("/{orderId}/events/{eventType}")
    public OrderLifecycleDocument addEvent(
            @PathVariable String orderId,
            @PathVariable String eventType) {
        return service.addEvent(orderId, eventType);
    }

    // Get order lifecycle
    @GetMapping("/{orderId}")
    public OrderLifecycleDocument getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }
}
