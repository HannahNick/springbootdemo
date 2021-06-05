package com.nick.springboot.controller;

import com.nick.springboot.dto.Order;
import com.nick.springboot.dto.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation("提交订单")
    @PostMapping("/commitOrder")
    public String commitOrder(@ApiParam("订单实体")@RequestBody Order order){
        return order.toString();
    }

    @PostMapping("/getUser")
    public User getUser(@RequestBody Order order){
        return new User();
    }


}
