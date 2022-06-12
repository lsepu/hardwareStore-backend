package com.hardwareStore.hardwareStore.usecases.Product;

import com.hardwareStore.hardwareStore.collection.Product;
import com.hardwareStore.hardwareStore.collection.Provider;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@SpringBootTest
class GetAllProductsUseCaseTest {

    private GetAllProductsUseCase getAllProductsUseCase;
    @Autowired
    private StoreMapper mapper;
    @Mock
    ProductRepository repository;

    @BeforeEach
    void setUp() {
        getAllProductsUseCase = new GetAllProductsUseCase(repository, mapper);
    }

    @Test
    void getAllProductsTest() {
        Provider provider1 = new Provider();
        provider1.setId("XXXX");
        provider1.setIdCard("100021323");
        provider1.setName("Pedro");
        provider1.setPhoneNumber("304524323");

        Product product1 = new Product();
        product1.setId("YYYY");
        product1.setName("Screw");
        product1.setDescription("A great screw");
        product1.setPrice(10000);
        product1.setQuantity(5);
        product1.setMinUnits(2);
        product1.setMaxUnits(10);
        product1.setProvider(provider1);


        Mockito.when(repository.findAll()).thenReturn(Flux.just(product1));
        Flux<ProductDTO> productDTOFlux = getAllProductsUseCase.get();

        StepVerifier.create(productDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();

    }


}