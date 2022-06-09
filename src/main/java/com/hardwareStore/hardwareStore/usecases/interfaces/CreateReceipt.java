package com.hardwareStore.hardwareStore.usecases.interfaces;

import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateReceipt {
    Mono<ReceiptDTO> apply (ReceiptDTO receiptDTO);
}
