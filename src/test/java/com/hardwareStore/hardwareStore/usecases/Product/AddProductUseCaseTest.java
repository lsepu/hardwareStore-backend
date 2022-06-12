package com.hardwareStore.hardwareStore.usecases.Product;
import com.hardwareStore.hardwareStore.collection.Provider;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddProductUseCaseTest {

    @MockBean
    AddProductUseCase addProductUseCase;

    @Test
    void addProductUseCaseTest(){
        Provider provider1 = new Provider();
        provider1.setId("XXXX");
        provider1.setIdCard("100021323");
        provider1.setName("Pedro");
        provider1.setPhoneNumber("304524323");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("YYYY");
        productDTO.setName("Screw");
        productDTO.setDescription("A great screw");
        productDTO.setPrice(10000);
        productDTO.setQuantity(5);
        productDTO.setMinUnits(2);
        productDTO.setMaxUnits(10);
        productDTO.setProvider(provider1);


        StepVerifier
                .create(Mono.just(Mockito.when(addProductUseCase.apply(productDTO))
                        .thenReturn(Mono.just(productDTO)))).expectNextCount(1).expectComplete().verify();
    }

}