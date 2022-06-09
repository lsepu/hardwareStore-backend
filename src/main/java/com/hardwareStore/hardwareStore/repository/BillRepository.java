package com.hardwareStore.hardwareStore.repository;

import com.hardwareStore.hardwareStore.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends ReactiveMongoRepository<Bill,String> {
}
