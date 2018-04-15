package nl.manoharanrajesh.spring.cloud.contract.producer;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Order {

    private final String id;

    @JsonCreator
    public Order(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                '}';
    }
}