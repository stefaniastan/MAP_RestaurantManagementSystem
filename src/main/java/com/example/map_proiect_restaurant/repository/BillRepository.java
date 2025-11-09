package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillRepository extends InFileRepository<Bill> {
    public BillRepository() {
        super(Bill.class, "src/main/resources/data/bills.json");
    }
}
