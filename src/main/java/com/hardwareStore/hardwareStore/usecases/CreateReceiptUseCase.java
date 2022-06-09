package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import com.hardwareStore.hardwareStore.repository.ReceiptRepository;
import com.hardwareStore.hardwareStore.usecases.interfaces.CreateReceipt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateReceiptUseCase implements CreateReceipt {

    private StoreMapper storeMapper;
    private ReceiptRepository receiptRepository;

    @Override
    public Mono<ReceiptDTO> apply(ReceiptDTO receiptDTO) {
        return receiptRepository
                .save(storeMapper.convertReceiptDTOToReceipt(receiptDTO)).map(receipt -> storeMapper.convertReceiptToReceiptDTO(receipt));
    }
}
