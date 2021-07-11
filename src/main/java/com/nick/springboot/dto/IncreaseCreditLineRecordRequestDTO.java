package com.nick.springboot.dto;

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
public class IncreaseCreditLineRecordRequestDTO extends BaseDTO{

    /**
     * 产品号
     */
    String productionCode;
    /**
     * 额度更新开始时间
     */
    Date updatedAtStartTime;
    /**
     * 额度更新结束时间
     */
    Date updatedAtEndTime;
    /**
     * 数据导入开始时间
     */
    Date createdAtStartTime;
    /**
     * 数据导入结束时间
     */
    Date createdAtEndTime;
    /**
     * 提额幅度最小值
     */
    BigDecimal increaseCreditLineMin;
    /**
     * 提额幅度最大值
     */
    BigDecimal increaseCreditLineMax;
    /**
     * 实际可用额度最小值
     */
    BigDecimal actualCreditLineMin;
    /**
     * 实际可用额度最大值
     */
    BigDecimal actualCreditLineMax;
}
