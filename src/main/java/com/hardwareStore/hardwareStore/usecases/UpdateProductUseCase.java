package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.repository.ProductRepository;
import com.hardwareStore.hardwareStore.usecases.interfaces.AddProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UpdateProductUseCase implements AddProduct {

    private StoreMapper storeMapper;
    private ProductRepository productRepository;

    @Override
    public Mono<ProductDTO> apply(ProductDTO productDTO) {
        Objects.requireNonNull(productDTO.getId());
        return productRepository
                .save(storeMapper.convertProductDTOToProduct(productDTO)).map(product -> storeMapper.convertProductToProductDTO(product));
    }

}
