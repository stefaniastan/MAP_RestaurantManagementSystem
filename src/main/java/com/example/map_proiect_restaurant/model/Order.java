package com.example.map_proiect_restaurant.model;

import java.util.List;

public class Order {
    private String Id;
    private String customerId;
    private String tableId;
    private String status;
    private List<OrderLine> orderLines;
    private List<OrderAssignment> assignments;
}
