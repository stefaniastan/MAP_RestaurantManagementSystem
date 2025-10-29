package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Bill;
import com.example.map_proiect_restaurant.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill addBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public Bill getBillById(String id){
        return billRepository.findById(id);
    }

    public void deleteBill(String id){
        billRepository.deleteById(id);
    }
}
