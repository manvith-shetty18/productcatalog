package com.fsd2425.productcatalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.fsd2425.productcatalog.Entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
