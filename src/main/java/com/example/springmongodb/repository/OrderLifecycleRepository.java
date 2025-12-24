package com.example.springmongodb.repository;
import com.example.springmongodb.document.OrderLifecycleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface OrderLifecycleRepository extends MongoRepository<OrderLifecycleDocument, String>{
    Optional<OrderLifecycleDocument> findByOrderId(String orderId);

}
