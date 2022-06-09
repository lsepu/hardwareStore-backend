package com.hardwareStore.hardwareStore.usecases;

import com.hardwareStore.hardwareStore.mapper.StoreMapper;
import com.hardwareStore.hardwareStore.model.BillDTO;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.repository.BillRepository;
import com.hardwareStore.hardwareStore.usecases.interfaces.CreateBill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateBillUseCase implements CreateBill {

    private StoreMapper storeMapper;
    private BillRepository billRepository;

    @Override
    public Mono<BillDTO> apply(BillDTO billDTO) {
        return billRepository
                .save(storeMapper.convertBillDTOtoBill(billDTO)).map(bill -> storeMapper.convertBillToBillDTO(bill));
    }

}
