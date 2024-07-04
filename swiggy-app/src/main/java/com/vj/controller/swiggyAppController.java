package com.vj.controller;


import com.vj.DTO.orderResponseDTO;
import com.vj.service.swiggyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/swiggy")
public class swiggyAppController {


    @Autowired
    swiggyAppService swiggyAppService;

    @GetMapping("/orders/{orderId}")
    public orderResponseDTO getOrderStatus(@PathVariable String orderId)
    {
        return  swiggyAppService.getOrderStatus(orderId) ;
    }
}
