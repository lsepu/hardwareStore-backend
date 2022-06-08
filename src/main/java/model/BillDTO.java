package model;

import lombok.Data;

import java.util.List;

@Data
public class BillDTO {

    private String id;
    private String date;
    private String clientName;
    private String salesPersonName;
    private List<String> products;

}
