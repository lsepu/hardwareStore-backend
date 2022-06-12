package com.hardwareStore.hardwareStore.usecases.Bill;

import com.hardwareStore.hardwareStore.collection.Bill;
import com.hardwareStore.hardwareStore.collection.ProductOrder;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.BillDTO;
import com.hardwareStore.hardwareStore.repository.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllBillsUseCaseTest {

    private GetAllBillsUseCase getAllBillsUseCase;

    @Autowired
    private StoreMapper mapper;

    @Mock
    BillRepository repository;

    @BeforeEach
    void setUp(){
        getAllBillsUseCase = new GetAllBillsUseCase(repository, mapper);
    }

    @Test
    void getAllBillsUseCaseTest(){

        ProductOrder productOrder1 = new ProductOrder();
        productOrder1.setId("ZZZZ");
        productOrder1.setName("Screw");
        productOrder1.setAmount(4);
        productOrder1.setTotal(35000);

        Bill bill1 = new Bill();
        bill1.setId("XXXX");
        bill1.setClientName("Juan");
        bill1.setDate("2022/06/11");
        bill1.setSalesPersonName("Pepe");
        bill1.setProducts(List.of(productOrder1));

        Mockito.when(repository.findAll()).thenReturn(Flux.just(bill1));
        Flux<BillDTO> billDTOFlux = getAllBillsUseCase.get();

        StepVerifier.create(billDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}