package com.vj.service;

import com.vj.DTO.orderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class swiggyAppService {

    @Autowired
   RestTemplate restTemplate ;
    public orderResponseDTO getOrderStatus(String orderId) {

        orderResponseDTO orderResponse = restTemplate.getForObject("http://localhost:8080/restaurant/orders/" + orderId, orderResponseDTO.class);
        return orderResponse ;
    }
}
