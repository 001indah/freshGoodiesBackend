package com.indah.freshGoodiesBackend.products.service;

import com.indah.freshGoodiesBackend.products.model.Product;

import java.util.List;
import java.util.Optional;

//verb
public interface ProductService {
    List<Product> getProducts();
    Optional<Product> getProducts(long id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Long id);
}

