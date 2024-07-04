package com.vj.Controller;


import com.vj.Dto.OrderResponseDTO;
import com.vj.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

        @Autowired
        RestaurantService restaurantService ;

        @GetMapping("/orders/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId)
    {
       return restaurantService.getOrder(orderId);
    }
}
