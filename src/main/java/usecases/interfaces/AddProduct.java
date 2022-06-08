package usecases.interfaces;

import model.ProductDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AddProduct {
    Mono<ProductDTO> apply (ProductDTO productDTO);
}
