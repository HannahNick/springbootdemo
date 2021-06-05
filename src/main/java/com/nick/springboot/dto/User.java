package com.nick.springboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author zwj
 * @date 2020/6/24
 */
@ApiModel("用户数据")
@Data
public class User {

    @NotNull
    @ApiModelProperty("用户id")
    private String userId;

    @Email
    @ApiModelProperty("邮件")
    private String email;

    @Length(max = 12,min = 4)
    @ApiModelProperty("用户名")
    private String name;


}
