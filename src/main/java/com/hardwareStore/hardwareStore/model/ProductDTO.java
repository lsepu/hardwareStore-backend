package com.hardwareStore.hardwareStore.model;

import com.hardwareStore.hardwareStore.collection.Provider;
import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer minUnits;
    private Integer maxUnits;
    private Integer quantity;
    private Provider provider;

}
