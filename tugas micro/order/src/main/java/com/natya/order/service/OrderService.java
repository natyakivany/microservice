package com.natya.order.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.natya.order.repository.OrderRepository;
import com.natya.order.vo.ResponseTemplate;
import com.natya.order.vo.produk;
import org.springframework.cloud.client.discovery.DiscoveryClient;


import jakarta.transaction.Transactional;

import com.natya.order.model.Order;

@Service
public class OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
    order.hitungTotal();
    return orderRepository.save(order);
}

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);

    }

    /**
     * @param id
     * @return
     */
    public List<ResponseTemplate> getOrderWithPodukById(long id){
        List<ResponseTemplate>responseList = new ArrayList<>();
        Order order = getOrderById(id);
        ServiceInstance serviceInstance = discoveryClient.getInstances("PRODUK").get(0);
        produk produk = restTemplate.getForObject(serviceInstance.getUri() + "/api/produk/" 
                + order.getProdukId(), produk.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        responseList.add(vo);
        return responseList;

    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

   @Transactional 
    public void hapusOrderByPelangganId(Long pelangganId) {
    orderRepository.deleteByPelangganId(pelangganId);
    }
}