package com.example.springmongodb.service;

import com.example.springmongodb.document.OrderLifecycleDocument;
import com.example.springmongodb.repository.OrderLifecycleRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLifecycleService {

    private final OrderLifecycleRepository repository;

    public OrderLifecycleService(OrderLifecycleRepository repository) {
        this.repository = repository;
    }

    public OrderLifecycleDocument createOrder(String orderId) {
        OrderLifecycleDocument document = new OrderLifecycleDocument(orderId);
        document.addEvent("orderPlaced");
        return repository.save(document);
    }
    public OrderLifecycleDocument addEvent(String orderId, String eventType) {
        OrderLifecycleDocument document = repository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        document.addEvent(eventType);
        return repository.save(document);
    }
    public OrderLifecycleDocument getOrder(String orderId) {
        return repository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
