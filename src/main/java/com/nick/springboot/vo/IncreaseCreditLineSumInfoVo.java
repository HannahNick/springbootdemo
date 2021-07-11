package com.nick.springboot.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * @author zwj
 * @date 2021/7/11
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncreaseCreditLineSumInfoVo {

    /**
     * 总条数
     */
    Long totalNum;

    /**
     * 实际可用额度总计
     */
    BigDecimal productionCreditLineSum;

    /**
     * 实际可用额度平均值
     */
    BigDecimal productionCreditLineAvg;

    /**
     * 提额总计总计
     */
    BigDecimal increaseCreditLineSum;

    /**
     * 提额总计平均值
     */
    BigDecimal increaseCreditLineAvg;


}
