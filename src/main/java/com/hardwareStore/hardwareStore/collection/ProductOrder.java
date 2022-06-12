package com.hardwareStore.hardwareStore.collection;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductOrder {
    private String id = UUID.randomUUID().toString().substring(0, 10);;
    private String name;
    private Integer amount;
    private Integer total;
}
