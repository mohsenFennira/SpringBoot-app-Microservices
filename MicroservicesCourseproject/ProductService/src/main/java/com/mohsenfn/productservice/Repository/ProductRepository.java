package com.mohsenfn.productservice.Repository;

import com.mohsenfn.productservice.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
