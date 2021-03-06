package com.hardwareStore.hardwareStore.model;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptDTO {

    private String id;
    private String date;
    private String providerName;
    private String productName;
    private Integer quantity;

}
