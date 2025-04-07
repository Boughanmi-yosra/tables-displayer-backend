package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.Product;
import com.yobo.tablesdisplayer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
