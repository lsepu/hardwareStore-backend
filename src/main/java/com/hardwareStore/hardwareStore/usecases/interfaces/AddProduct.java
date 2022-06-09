package com.hardwareStore.hardwareStore.usecases.interfaces;

import com.hardwareStore.hardwareStore.model.ProductDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AddProduct {
    Mono<ProductDTO> apply (ProductDTO productDTO);
}
