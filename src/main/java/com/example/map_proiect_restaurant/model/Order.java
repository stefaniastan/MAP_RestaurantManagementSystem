package com.example.map_proiect_restaurant.model;

import java.util.List;

public class Order {
    private String Id;
    private String customerId;
    private String tableId;
    private String status;
    private List<OrderLine> orderLines;
    private List<OrderAssignment> assignments;

    public Order(String Id, String customerId, String tableId, String status, List<OrderLine> orderLines, List<OrderAssignment> assignments) {
        this.Id = Id;
        this.customerId = customerId;
        this.tableId = tableId;
        this.status = status;
        this.orderLines = orderLines;
        this.assignments = assignments;

    }

    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTableId() {
        return tableId;
    }
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<OrderAssignment> getAssignments() {
        return assignments;
    }
    public void setAssignments(List<OrderAssignment> assignments) {
        this.assignments = assignments;
    }
}
