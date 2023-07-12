package com.mohsenfn.cloudgateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallback(){
        return "Order Service is down!";
    }
    @GetMapping("/productServiceFallBack")
    public String productServiceFallback(){
        return "product Service is down!";
    }
    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallback(){
        return "payment Service is down!";
    }
    @GetMapping("/authServiceFallBack")
    public String authServiceFallback(){
        return "auth Service is down!";
    }
}
