package com.mohsenfn.productservice.Service;

import com.mohsenfn.productservice.Entity.Product;

public interface ProductIService {
    public Product addProduct(Product product);
    public Product getProductById(Long id);
    public void ReduceQuantity(Long id,Long quantity);
}
