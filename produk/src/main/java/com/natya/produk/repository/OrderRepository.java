package com.natya.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.natya.produk.model.Order; 

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Spring Boot otomatis akan membuatkan query DELETE berdasarkan pelangganId
    void deleteByPelangganId(Long pelangganId);
    
}
