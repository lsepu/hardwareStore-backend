package com.hardwareStore.hardwareStore.usecases.Bill;

import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.BillDTO;
import com.hardwareStore.hardwareStore.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
public class GetAllBillsUseCase {

    private final BillRepository repository;
    private final StoreMapper storeMapper;


    public Flux<BillDTO> get(){
        return repository.findAll().map(storeMapper::convertBillToBillDTO);
    }

}
