package com.natya.order.vo;

import com.natya.order.model.Order;

import lombok.Data;

@Data
public class ResponseTemplate {
    Order order;
    produk produk;
}
