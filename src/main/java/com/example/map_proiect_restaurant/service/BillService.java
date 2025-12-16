package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Bill;
import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.repository.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> filterAndSortBills(
            Long orderId,
            Double minAmount,
            Double maxAmount,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        if (orderId != null) {
            return billRepository.findByOrder_Id(orderId);
        }

        if (minAmount != null && maxAmount != null) {
            return billRepository.findByTotalAmountBetween(minAmount, maxAmount);
        }

        return billRepository.findAll(sort);
    }

    public Bill addBill(Bill bill) {
        Long orderId = bill.getOrder().getId();

        //prevent duplicate bill
        if (!billRepository.findByOrderId(orderId).isEmpty()) {
            throw new IllegalStateException("This order already has a bill.");
        }

        return billRepository.save(bill);
    }


    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
    }

    public void deleteBill(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        Order order = bill.getOrder();
        if (order != null) {
            order.setBill(null);
        }

        bill.setOrder(null);

        billRepository.delete(bill);
    }

    public List<Bill> getBillsByOrderId(Long orderId) {
        return billRepository.findByOrderId(orderId);
    }
}