package com.hardwareStore.hardwareStore.usecases.Provider;

import com.hardwareStore.hardwareStore.collection.Provider;
import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ProviderDTO;
import com.hardwareStore.hardwareStore.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProvidersUseCaseTest {

    private GetAllProvidersUseCase getAllProvidersUseCase;
    @Autowired
    private StoreMapper mapper;
    @Mock
    ProviderRepository repository;

    @BeforeEach
    void setUp() {
        getAllProvidersUseCase = new GetAllProvidersUseCase(repository, mapper);
    }

    @Test
    void getAllProvidersUseCaseTest() {
        Provider provider1 = new Provider();
        Provider provider2 = new Provider();

        provider1.setId("XXXX");
        provider1.setIdCard("100021323");
        provider1.setName("Pedro");
        provider1.setPhoneNumber("304524323");

        provider2.setId("YYYY");
        provider2.setIdCard("3123123");
        provider2.setName("Juan");
        provider2.setPhoneNumber("3937136");

        Mockito.when(repository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDTO> providerDTOFlux = getAllProvidersUseCase.get();

        StepVerifier.create(providerDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}