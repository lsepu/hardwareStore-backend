package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.usecases.interfaces.AddProduct;
import lombok.AllArgsConstructor;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.hardwareStore.hardwareStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class AddProductUseCase implements AddProduct {

    private StoreMapper storeMapper;
    private ProductRepository productRepository;

    @Override
    public Mono<ProductDTO> apply(ProductDTO productDTO) {
        return productRepository
                .save(storeMapper.convertProductDTOToProduct(productDTO)).map(product -> storeMapper.convertProductToProductDTO(product));
    }
}
