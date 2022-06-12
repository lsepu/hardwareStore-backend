package com.hardwareStore.hardwareStore.usecases.Receipt;

import com.hardwareStore.hardwareStore.collection.Receipt;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import com.hardwareStore.hardwareStore.repository.ReceiptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllReceiptsUseCaseTest {

    private GetAllReceiptsUseCase getAllReceiptsUseCase;

    @Autowired
    private StoreMapper mapper;

    @Mock
    private ReceiptRepository repository;

    @BeforeEach
    void setUp() {
        getAllReceiptsUseCase = new GetAllReceiptsUseCase(repository, mapper);
    }

    @Test
    void getAllReceiptsUseCaseTest(){
        Receipt receipt1 = new Receipt();
        receipt1.setId("XXXX");
        receipt1.setProductName("Screw");
        receipt1.setDate("2022/06/11");
        receipt1.setProviderName("Pedro");
        receipt1.setQuantity(4);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(receipt1));
        Flux<ReceiptDTO> receiptDTOFlux = getAllReceiptsUseCase.get();

        StepVerifier.create(receiptDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }


}