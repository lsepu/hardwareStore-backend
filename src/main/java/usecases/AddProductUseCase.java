package usecases;

import lombok.AllArgsConstructor;
import mapper.StoreMapper;
import model.ProductDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.ProductRepository;
import usecases.interfaces.AddProduct;

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
