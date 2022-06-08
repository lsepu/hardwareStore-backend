package usecases;

import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.ProviderRepository;
import usecases.interfaces.DeleteFromStore;

@Service
@AllArgsConstructor
public class DeleteProviderUseCase implements DeleteFromStore {

    private final ProviderRepository providerRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<Void> apply(String id) {
        return providerRepository.deleteById(id);
    }

}
