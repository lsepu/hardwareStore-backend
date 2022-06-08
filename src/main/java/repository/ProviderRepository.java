package repository;

import collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProviderRepository extends ReactiveMongoRepository<Provider,String> {
}
