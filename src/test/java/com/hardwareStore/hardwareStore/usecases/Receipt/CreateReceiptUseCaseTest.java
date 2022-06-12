package com.hardwareStore.hardwareStore.usecases.Receipt;

import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateReceiptUseCaseTest {

    @MockBean
    CreateReceiptUseCase createReceiptUseCase;
    
    @Test
    void createReceiptUseCaseTest(){
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId("XXXX");
        receiptDTO.setProductName("Screw");
        receiptDTO.setDate("2022/06/11");
        receiptDTO.setProviderName("Pedro");
        receiptDTO.setQuantity(4);

        StepVerifier
                .create(Mono.just(Mockito.when(createReceiptUseCase.apply(receiptDTO))
                        .thenReturn(Mono.just(receiptDTO)))).expectNextCount(1).expectComplete().verify();
        
    }
    
}