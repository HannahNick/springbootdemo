package com.nick.springboot.controller;

import com.nick.springboot.dto.Order;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zwj
 * @date 2020/6/24
 */
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @PostMapping("/commitOrder")
    public String commitOrder(@RequestBody Order order){
        return order.toString();
    }
}
