package com.hardwareStore.hardwareStore.repository;

import com.hardwareStore.hardwareStore.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider,String> {
}
