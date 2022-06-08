package usecases;


import mapper.StoreMapper;
import model.ProviderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import repository.ProviderRepository;

@Service
public class GetAllProvidersUseCase {

    private final ProviderRepository repository;
    private final StoreMapper storeMapper;

    public GetAllProvidersUseCase(ProviderRepository repository, StoreMapper storeMapper) {
        this.repository = repository;
        this.storeMapper = storeMapper;
    }

    public Flux<ProviderDTO> get(){
        return repository.findAll().map(storeMapper::convertProviderToProviderDTO);
    }

}
