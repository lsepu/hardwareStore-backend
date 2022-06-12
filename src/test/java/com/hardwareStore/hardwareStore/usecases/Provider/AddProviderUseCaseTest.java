package com.hardwareStore.hardwareStore.usecases.Provider;

import com.hardwareStore.hardwareStore.model.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddProviderUseCaseTest {

    @MockBean
    AddProviderUseCase addProviderUseCase;

    @Test
    void addProviderUseCaseTest() {

        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId("XXXX");
        providerDTO.setIdCard("100021323");
        providerDTO.setName("Pedro");
        providerDTO.setPhoneNumber("304524323");

        StepVerifier
                .create(Mono.just(Mockito.when(addProviderUseCase.apply(providerDTO))
                        .thenReturn(Mono.just(providerDTO)))).expectNextCount(1).expectComplete().verify();

    }


}