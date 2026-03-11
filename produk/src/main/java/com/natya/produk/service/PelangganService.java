package com.natya.produk.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natya.produk.repository.PelangganRepository;
import com.natya.produk.model.Pelanggan;



@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganById(Long id) {
        return pelangganRepository.findById(id).orElse(null);
    }

    public Pelanggan createPelanggan(Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    public void deletePelanggan(Long id) {
        pelangganRepository.deleteById(id);
    }

   

}