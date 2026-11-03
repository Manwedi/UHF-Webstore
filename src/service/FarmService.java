package service;

import repository.*;

public class FarmService {
    private final FarmRepository repository;

    public FarmService(FarmRepository repository) {  // Constructor for dependency injection
        this.repository = repository;
    }

    public List<ChickenBatch> getAllBatches() {
        return repository.getAllBatches().stream()
                .sorted(Comparator.comparing(ChickenBatch::getBatchId))
                .collect(Collectors.toList());
    }

    public synchronized Order placeOrder(String customerName, String batchId, int quantity) {
        ChickenBatch batch = repository.getBatchById(batchId);
        if (batch == null) {
            throw new IllegalArgumentException("Batch not found: " + batchId);
        }
        if (quantity > batch.getAvailableQuantity()) {
            throw new IllegalArgumentException("Not enough chickens available in batch: " + batchId);
        }

        double totalPrice = quantity * batch.getPricePerChicken();
        double totalWeight = quantity * batch.getAverageWeight();

        ChickenBatch updatedBatch = new ChickenBatch(
                batch.getBatchId(),
                batch.getBreed(),
                batch.getTotalQuantity(),
                batch.getAvailableQuantity() - quantity,
                batch.getAverageWeight(),
                batch.getPricePerChicken()
        );

        String orderId = repository.generateOrderId();
        Order order = new Order(orderId, customerName, batchId, quantity, totalPrice, totalWeight); 
        repository.addOrder(order);

        return order;
    }
}
