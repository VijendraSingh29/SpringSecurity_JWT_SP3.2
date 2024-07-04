package com.vj.Services;


import com.vj.Dao.RestaurantOrderDAO;
import com.vj.Dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantOrderDAO restaurantOrderDAO ;
    public OrderResponseDTO getOrder(String orderId) {

           return restaurantOrderDAO.getOrder(orderId) ;
    }

}
