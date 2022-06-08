package usecases;

import mapper.StoreMapper;
import model.ProductDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import repository.ProductRepository;

@Service
public class GetAllProductsUseCase {

    private final ProductRepository repository;
    private final StoreMapper storeMapper;

    public GetAllProductsUseCase(ProductRepository repository, StoreMapper storeMapper) {
        this.repository = repository;
        this.storeMapper = storeMapper;
    }

    public Flux<ProductDTO> get(){
        return repository.findAll().map(storeMapper::convertProductToProductDTO);
    }

}
