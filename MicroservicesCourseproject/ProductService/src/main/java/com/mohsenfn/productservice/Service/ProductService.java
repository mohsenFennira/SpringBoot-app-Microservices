package com.mohsenfn.productservice.Service;

import com.mohsenfn.productservice.Entity.Product;
import com.mohsenfn.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductIService{
    @Autowired
    ProductRepository pr;
    @Override
    public Product addProduct(Product product) {
        return pr.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return pr.findById(id).get();
    }

    @Override
    public void ReduceQuantity(Long id,Long quantity) {
        Product product=pr.findById(id).get();
        if(product.getQuantity()>quantity){
            product.setQuantity(product.getQuantity()-quantity);
            pr.save(product);
        }
    }
}
