package com.hardwareStore.hardwareStore.usecases.Provider;

import com.hardwareStore.hardwareStore.model.ProviderDTO;
import com.hardwareStore.hardwareStore.usecases.interfaces.AddProvider;
import lombok.AllArgsConstructor;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.hardwareStore.hardwareStore.repository.ProviderRepository;

@Service
@AllArgsConstructor
public class AddProviderUseCase implements AddProvider {

    private StoreMapper storeMapper;
    private ProviderRepository providerRepository;


    @Override
    public Mono<ProviderDTO> apply(ProviderDTO providerDTO) {
        return providerRepository
                .save(storeMapper.convertProviderDTOToProvider(providerDTO)).map(provider -> storeMapper.convertProviderToProviderDTO(provider));
    }
}
