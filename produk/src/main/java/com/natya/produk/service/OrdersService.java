package com.natya.produk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natya.produk.repository.OrdersRepository;
import com.natya.produk.model.Orders;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders createOrders(Orders order) {
        return ordersRepository.save(order);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }

    

}