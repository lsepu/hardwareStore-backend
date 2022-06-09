package com.hardwareStore.hardwareStore.usecases.interfaces;

import com.hardwareStore.hardwareStore.model.BillDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateBill {
    Mono<BillDTO> apply (BillDTO billDTO);
}
