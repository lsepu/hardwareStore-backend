package usecases;

import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import model.ProviderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.ProviderRepository;
import usecases.interfaces.AddProvider;

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
