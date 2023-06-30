package com.mohsenfn.productservice.Controller;

import com.mohsenfn.productservice.Entity.Product;
import com.mohsenfn.productservice.Service.ProductIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductContoller {
    @Autowired
    ProductIService pis;
    @PostMapping("addProduct")
    public Product addProduct(@RequestBody Product product) {
        return pis.addProduct(product);
    }
    @GetMapping
    public Product getProductById(@RequestParam Long id) {
        return pis.getProductById(id);
    }
   @PutMapping("ReduceQuantity")
    public void ReduceQuantity(@RequestParam Long id,@RequestParam Long quantity) {
         pis.ReduceQuantity(id, quantity);
    }
    }
