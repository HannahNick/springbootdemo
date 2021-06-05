package com.nick.springboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author zwj
 * @date 2020/6/24
 */
@Data
@ApiModel("订单类")
public class Order {

    @ApiModelProperty("订单id")
    @NotBlank(message = "订单id不能为空")
    private String orderId;
    @ApiModelProperty("是否是vip用户")
    @AssertTrue(message = "当前用户不是vip用户")
    private Boolean isVip;
    @ApiModelProperty("订单单价")
    @Digits(message = "当前价格不能超过1000.30",integer = 1000,fraction = 2)
    private BigDecimal price;
    @ApiModelProperty("订单商品数量")
    @Range(min = 1,max = 10,message = "订单商品数量不能超过10")
    private int num;

}
