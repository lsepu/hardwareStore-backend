package com.hardwareStore.hardwareStore.mapper;

import com.hardwareStore.hardwareStore.collection.Bill;
import com.hardwareStore.hardwareStore.collection.Product;
import com.hardwareStore.hardwareStore.collection.Provider;
import com.hardwareStore.hardwareStore.collection.Receipt;
import com.hardwareStore.hardwareStore.model.BillDTO;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.model.ProviderDTO;
import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    private ModelMapper modelMapper;

    public StoreMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProductDTO convertProductToProductDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertProductDTOToProduct(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

    public ProviderDTO convertProviderToProviderDTO(Provider provider){
        return modelMapper.map(provider, ProviderDTO.class);
    }

    public Provider convertProviderDTOToProvider(ProviderDTO providerDTO){
        return modelMapper.map(providerDTO, Provider.class);
    }

    public ReceiptDTO convertReceiptToReceiptDTO(Receipt receipt){
        return modelMapper.map(receipt, ReceiptDTO.class);
    }

    public Receipt convertReceiptDTOToReceipt(ReceiptDTO receiptDTO){
        return modelMapper.map(receiptDTO, Receipt.class);
    }

    public BillDTO convertBillToBillDTO(Bill bill){
        return modelMapper.map(bill, BillDTO.class);
    }

    public Bill convertDTOtoBill(BillDTO billDTO){
        return modelMapper.map(billDTO, Bill.class);
    }


}
