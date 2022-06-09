package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import com.hardwareStore.hardwareStore.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptsUseCase {

    private final ReceiptRepository repository;
    private final StoreMapper storeMapper;


    public Flux<ReceiptDTO> get(){
        return repository.findAll().map(storeMapper::convertReceiptToReceiptDTO);
    }

}
