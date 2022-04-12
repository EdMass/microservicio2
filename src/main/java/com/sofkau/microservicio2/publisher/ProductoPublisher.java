package com.sofkau.microservicio2.publisher;

import com.sofkau.microservicio2.config.MessagingConfig;
import com.sofkau.microservicio2.model.Producto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/")
    public String bookOrder(@RequestBody Producto producto) {

        //OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, producto);
        return "Success !!";
    }

}
