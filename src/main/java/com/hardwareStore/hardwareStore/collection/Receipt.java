package com.hardwareStore.hardwareStore.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "receipt")
public class Receipt {

    @Id
    private String id;
    private String date;
    private String providerName;
    private List<String> products;
}
