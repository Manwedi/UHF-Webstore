package service;

import repository.*;
import domain.*;
import java.util.*;

public class FarmService {
    private final FarmRepository repository;

    public FarmService(FarmRepository repository) {  // Constructor for dependency injection
        this.repository = repository;
    }

    public List<ChickenBatch> getAllBatches() {
        return repository.getAllBatches().stream()
                .filter(ChickenBatch::isAvailable)
                .filter(b -> b.getQuantityAvailable() > 0)
                .toList();
    }

    public synchronized Order placeOrder(String customerName, String batchId, int quantity) throws IllegalArgumentException {

        ChickenBatch batch = repository.getBatchById(batchId)  // check if the batch exists
            .orElseThrow(() -> new IllegalArgumentException("Batch is not found: " + batchId));

        // Verifiying if the batch exists     
        if (!batch.isAvailable()) {
            throw new IllegalArgumentException("This batch is not ready for market yet.");
        }

        // This block checks if the requested quantity is available in the batch. If not, it throws an exception.
        if (batch.getQuantityAvailable() < quantity) {
            throw new IllegalArgumentException("Insufficient stock! Requested: " + quantity + ", Available: " + batch.getQuantityAvailable());
        }

        double totalPrice = quantity * batch.getPrice();
        double totalWeight = quantity * batch.getWeight();

        ChickenBatch updatedBatch = new ChickenBatch(
                batch.getID(),
                batch.getBreed(),
                batch.getQuantityAvailable(),
                batch.getQuantity() - quantity,
                batch.getWeight(),
                batch.getPrice()
        );

        String orderId = repository.generateOrderId();
        Order order = new Order(orderId, customerName, batchId, quantity, totalPrice); 
        repository.addOrder(order);

        return order;
    }
}
