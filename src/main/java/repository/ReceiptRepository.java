package repository;

import collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
