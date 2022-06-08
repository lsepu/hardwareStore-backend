package repository;

import collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillRepository extends ReactiveMongoRepository<Bill,String> {
}
