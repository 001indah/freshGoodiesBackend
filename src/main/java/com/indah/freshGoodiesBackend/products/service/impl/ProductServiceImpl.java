package com.indah.freshGoodiesBackend.products.service.impl;
import com.indah.freshGoodiesBackend.exception.ApplicationException;
import com.indah.freshGoodiesBackend.products.model.Product;
import com.indah.freshGoodiesBackend.products.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class ProductServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProducts(long id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    @Override
    public Product addProduct(Product product) {
        boolean exists = products.stream().anyMatch(p -> p.getId() == product.getId());
        if (exists){
            throw new ApplicationException("Product with ID" + product.getId() + "already exist.");
        }
        products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product currentProduct = products.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst()
                .orElse(null);

        if (currentProduct != null) {
            currentProduct.setName(product.getName());
            currentProduct.setCategory(product.getCategory());
            currentProduct.setImageUrl(product.getImageUrl());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setWeight(product.getWeight());
            currentProduct.setMetadata(product.getMetadata());
        }

        return currentProduct;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> product = getProducts(id);
        if (product.isPresent()) {
            products.remove(product.get());
            return true;
        } else {
            return false;
        }
    }


}
