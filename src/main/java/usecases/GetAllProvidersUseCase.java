package usecases;


import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import model.ProviderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import repository.ProviderRepository;

@Service
@AllArgsConstructor
public class GetAllProvidersUseCase {

    private final ProviderRepository repository;
    private final StoreMapper storeMapper;

    public Flux<ProviderDTO> get(){
        return repository.findAll().map(storeMapper::convertProviderToProviderDTO);
    }

}
