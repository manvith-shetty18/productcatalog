package com.fsd2425.productcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsd2425.productcatalog.Entity.Product;
import com.fsd2425.productcatalog.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(String id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPhoto(productDetails.getPhoto());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setDescription(productDetails.getDescription());
            product.setIngredients(productDetails.getIngredients());
            return productRepository.save(product);
        });
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}