package com.hardwareStore.hardwareStore.model;

import com.hardwareStore.hardwareStore.collection.Product;
import com.hardwareStore.hardwareStore.collection.ProductOrder;
import lombok.Data;

import java.util.List;

@Data
public class BillDTO {

    private String id;
    private String date;
    private String clientName;
    private String salesPersonName;
    private List<ProductOrder> products;

}
