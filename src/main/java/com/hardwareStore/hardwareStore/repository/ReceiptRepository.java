package com.hardwareStore.hardwareStore.repository;

import com.hardwareStore.hardwareStore.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
