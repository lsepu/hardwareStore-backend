package usecases;

import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import model.ProductDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import repository.ProductRepository;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private final ProductRepository repository;
    private final StoreMapper storeMapper;


    public Flux<ProductDTO> get(){
        return repository.findAll().map(storeMapper::convertProductToProductDTO);
    }

}
