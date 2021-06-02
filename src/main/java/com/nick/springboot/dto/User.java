package com.nick.springboot.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author zwj
 * @date 2020/6/24
 */
@Data
public class User {

    @NotNull
    private String userId;

    @Email
    private String email;

    @Length(max = 12,min = 4)
    private String name;


}
