package com.hardwareStore.hardwareStore.repository;

import com.hardwareStore.hardwareStore.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
