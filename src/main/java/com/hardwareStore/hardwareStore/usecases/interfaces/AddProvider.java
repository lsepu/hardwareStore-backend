package com.hardwareStore.hardwareStore.usecases.interfaces;

import com.hardwareStore.hardwareStore.model.ProviderDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AddProvider {
    Mono<ProviderDTO> apply (ProviderDTO providerDTO);
}
