package com.nick.springboot.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 *
 * @author zwj
 * @date 2020/10/22
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillDocUserInfo implements Serializable {

    String id;

    /*-------------------------------------单据相关字段------------------------------------------------**/
    /**
     * 单据编码
     */
    String billDocNo;

    /*-------------------------------------客户相关字段------------------------------------------------**/
    /**
     * 用户ID
     */
    String customerUserId;

    /**
     * 客户ID
     */
    String customerId;

    /**
     * 客户号
     */
    String customerAccount;

    /**
     * 客户名称
     */
    String customerName;

    /**
     * 手机号
     */
    String customerContact;

    /**
     * 业务员ID
     */
    String marketerNo;

    /**
     * 业务员名称
     */
    String marketerName;

    /**
     * 业务员部门ID
     */
    String marketerDptId;

    /**
     * 业务员部门名称
     */
    String marketerDptName;


    /*-------------------------------------内部客户相关字段------------------------------------------------**/

    /**
     * 用户ID
     */
    String ownerCustomerUserId;

    /**
     * 客户ID
     */
    String ownerCustomerId;

    /**
     * 客户号
     */
    String ownerCustomerAccount;

    /**
     * 客户名称
     */
    String ownerCustomerName;

    /**
     * 手机号
     */
    String ownerCustomerContact;


    /**
     * 市场ID
     */
    String marketId;

    /**
     * 市场名称
     */
    String marketName;
}
