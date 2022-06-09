package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.usecases.interfaces.DeleteFromStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.hardwareStore.hardwareStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class DeleteProductUseCase implements DeleteFromStore {

    private final ProductRepository productRepository;

    @Override
    public Mono<Void> apply(String id) {
        return productRepository.deleteById(id);
    }
}
