package com.hardwareStore.hardwareStore.usecases;


import com.hardwareStore.hardwareStore.model.ProviderDTO;
import lombok.AllArgsConstructor;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.hardwareStore.hardwareStore.repository.ProviderRepository;

@Service
@AllArgsConstructor
public class GetAllProvidersUseCase {

    private final ProviderRepository repository;
    private final StoreMapper storeMapper;

    public Flux<ProviderDTO> get(){
        return repository.findAll().map(storeMapper::convertProviderToProviderDTO);
    }

}
