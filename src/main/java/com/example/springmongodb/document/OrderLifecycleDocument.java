package com.example.springmongodb.document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

@Document(collection="order_lifecycle")
public class OrderLifecycleDocument {
    @Id
    private String id;
    private String orderId;

    private List<OrderEvent> events=new ArrayList<>();

    public static class OrderEvent{
        private String type;
        private Instant time;

        public OrderEvent(){

        }

        public OrderEvent(String type, Instant time) {
            this.type = type;
            this.time=time;

        }
        public String getType() {
            return type;
        }
        public Instant getTime() {
            return time;

        }
    }
 public OrderLifecycleDocument(){

}

public OrderLifecycleDocument(String orderId) {
        this.orderId=orderId;
}

public String getId(){
        return id;
}

public String getOrderId(){
        return orderId;
}

public List<OrderEvent> getEvents(){
        return List.copyOf(events);
}

public void addEvent(String type){
        this.events.add(new OrderEvent(type,Instant.now()));
}

}
