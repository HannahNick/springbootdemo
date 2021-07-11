package com.nick.springboot.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zwj
 * @date 2021/7/11
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncreaseCreditLineRecord {

    /**
     * 主键
     */
    Long id;

    /**
     * 用户uuid
     */
    Long uuid;

    /**
     * 产品code
     */
    String productionCode;

    /**
     * 授信额度
     */
    BigDecimal creditLine;

    /**
     * 授信额度
     */
    BigDecimal usedCreditLine;

    /**
     * 已用额度
     */
    BigDecimal actualCreditLine;

    /**
     * 实际可用额度
     */
    BigDecimal productionCreditLine;

    /**
     * 提额幅度
     */
    BigDecimal increaseCreditLine;

    /**
     * 状态
     */
    String state;

    /**
     * 提额幅度
     */
    String upCreditLine;

    /**
     * 提额时间
     */
    Date creditLineUpdatedAt;

    /**
     * 创建人
     */
    String createdBy;

    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;

}
