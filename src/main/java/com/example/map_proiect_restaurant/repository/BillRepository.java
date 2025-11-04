package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@Repository
public class BillRepository implements AbstractRepository<Bill> {
    private final List<Bill> bills = new ArrayList<>(Arrays.asList(
            new Bill("Bill1", "Order1", 25.5),
            new Bill("Bill2", "Order2", 57)
    ));

    @Override
    public Bill save(Bill bill) {
        bills.add(bill);
        return bill;
    }

    @Override
    public List<Bill> findAll() {
        return bills;
    }

    @Override
    public Bill findById(String id) {
        for (Bill bill : bills) {
            if (bill.getId().equals(id)) {
                return bill;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        bills.removeIf(bill -> bill.getId().equals(id));
    }

}
