package com.hardwareStore.hardwareStore.usecases.Provider;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.hardwareStore.hardwareStore.repository.ProviderRepository;
import com.hardwareStore.hardwareStore.usecases.interfaces.DeleteFromStore;

@Service
@AllArgsConstructor
public class DeleteProviderUseCase implements DeleteFromStore {

    private final ProviderRepository providerRepository;

    @Override
    public Mono<Void> apply(String id) {
        return providerRepository.deleteById(id);
    }

}
