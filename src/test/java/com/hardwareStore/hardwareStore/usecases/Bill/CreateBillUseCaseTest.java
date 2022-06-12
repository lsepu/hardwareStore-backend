package com.hardwareStore.hardwareStore.usecases.Bill;

import com.hardwareStore.hardwareStore.collection.ProductOrder;
import com.hardwareStore.hardwareStore.model.BillDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateBillUseCaseTest {

    @MockBean
    CreateBillUseCase createBillUseCase;

    @Test
    void createBillUseCaseTest() {
        ProductOrder productOrder1 = new ProductOrder();
        productOrder1.setId("ZZZZ");
        productOrder1.setName("Screw");
        productOrder1.setAmount(4);
        productOrder1.setTotal(35000);

        BillDTO billDTO = new BillDTO();
        billDTO.setId("XXXX");
        billDTO.setClientName("Juan");
        billDTO.setDate("2022/06/11");
        billDTO.setSalesPersonName("Pepe");
        billDTO.setProducts(List.of(productOrder1));


        StepVerifier
                .create(Mono.just(Mockito.when(createBillUseCase.apply(billDTO))
                        .thenReturn(Mono.just(billDTO)))).expectNextCount(1).expectComplete().verify();
    }
}