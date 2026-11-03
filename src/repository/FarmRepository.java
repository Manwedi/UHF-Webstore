package repository;

import domain.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FarmRepository {
    
    private final Map<String, ChickenBatch> batches = new ConcurrentHashMap<>();
    private final List<Order> orders = Collections.synchronizedList(new ArrayList<>());

    public FarmRepository() { // Initialize with some sample data
        batches.put("Batch-001", new ChickenBatch("B01-02112026", "Cobb-500", 800, 790, 2.3, 1.5));
        batches.put("Batch-002", new ChickenBatch("B01-02112026", "Cobb-500", 800, 790, 2.3, 1.5));
    }

    public List<ChickenBatch> getAllBatches() {
        return new ArrayList<>(batches.values());
    }

    public Optional<ChickenBatch> getBatchById(String batchId) {
        return Optional.ofNullable(batches.get(batchId));
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public String generateOrderId() {
        return "ORDER-" + (orders.size() + 1);
    }
}
