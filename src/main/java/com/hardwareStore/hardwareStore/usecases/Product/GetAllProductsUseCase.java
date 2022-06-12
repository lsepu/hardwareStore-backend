package com.hardwareStore.hardwareStore.usecases.Product;

import com.hardwareStore.hardwareStore.model.ProductDTO;
import lombok.AllArgsConstructor;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.hardwareStore.hardwareStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private final ProductRepository repository;
    private final StoreMapper storeMapper;


    public Flux<ProductDTO> get(){
        return repository.findAll().map(storeMapper::convertProductToProductDTO);
    }

}
