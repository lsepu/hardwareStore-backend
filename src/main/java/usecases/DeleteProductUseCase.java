package usecases;

import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.ProductRepository;
import usecases.interfaces.DeleteFromStore;

@Service
@AllArgsConstructor
public class DeleteProductUseCase implements DeleteFromStore {

    private final ProductRepository productRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<Void> apply(String id) {
        return productRepository.deleteById(id);
    }
}
