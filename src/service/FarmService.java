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
}
