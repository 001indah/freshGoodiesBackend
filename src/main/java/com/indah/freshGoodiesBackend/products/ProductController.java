package com.indah.freshGoodiesBackend.products;
import com.indah.freshGoodiesBackend.responses.Response;
import com.indah.freshGoodiesBackend.products.model.Product;
import com.indah.freshGoodiesBackend.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/products")
@Log
@Validated
public class ProductController {
    private final ProductService productService;

    //Construction dependency injection
    public ProductController (ProductService productService){
        this.productService = productService;
    }

    //Get all product
    @GetMapping
    public ResponseEntity<Response<List<Product>>> getProduct(){
        return Response.successfulResponse("All product fetched", productService.getProducts());
    }

    //Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Product>>> getProduct(@PathVariable Long id){
        var productFound = productService.getProducts(id);
        if (productFound.isEmpty()){
            return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Product not found");
        }
        return Response.successfulResponse("Product detail found", productFound);
    }

    //update product by id
    @PutMapping
    public ResponseEntity<Response<Product>> updateProduct(@Valid @RequestBody Product product){
        return Response.successfulResponse("Update Product Success", productService.updateProduct(product));
    }

    //Create product
    @PostMapping
    public ResponseEntity<Response<Product>> createProduct(@Validated @RequestBody Product product) {
        var createdProduct = productService.addProduct(product);
        return Response.successfulResponse(HttpStatus.CREATED.value(), "New product created", createdProduct);
    }

    //delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return Response.successfulResponse(HttpStatus.NO_CONTENT.value(), "Product deleted successfully", null);
        } else {
            return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Product not found");
        }
    }


}
