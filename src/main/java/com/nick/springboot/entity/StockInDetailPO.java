package com.nick.springboot.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

/**
 * 入库详情表
 *
 * @author zwj
 * @date 2020/7/30
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockInDetailPO {

    String id;

    /**
     * 入库单号
     */
    String parentId;

    /**
     * 入库单编号
     */
    String stockInNo;

    /**
     * 来源单号(采购单详情)
     */
    String sourceNo;

    /**
     * 货池货物id
     */
    String wmsStockId;

    /**
     * 批次号
     */
    String batchNo;

    /**
     * 库存id
     */
    String stockId;

    /**
     * skuId
     */
    String skuId;

    /**
     * sku编码
     */
    String skuNo;

    /**
     * sku名称
     */
    String skuName;

    /**
     * sku属性
     */
    String skuAttribute;

    /**
     * sku属性id
     */
    String skuAttributeId;

    /**
     * 入库数量
     */
    BigDecimal inNumber;

    /**
     * 申请数量(交货确认数量)
     */
    BigDecimal applyNumber;

    /**
     * 计量单位编码
     */
    String unitCode;

    /**
     * 计量单位名
     */
    String unitName;

    /**
     * 货物单价
     */
    BigDecimal skuPrice;

    /**
     * 货物单价(不含税)
     */
    BigDecimal skuPriceExcludeTax;

    /**
     * 货物总价
     */
    BigDecimal totalPrice;

    /**
     * 货物总价(不含税)
     */
    BigDecimal totalPriceExcludeTax;

    /**
     * 税额
     */
    BigDecimal tax;

    /**
     * 税率
     */
    BigDecimal taxRate;

    /**
     * 原批次号
     */
    String sourceBatchNo;

    /**
     * 辅助数量
     */
    BigDecimal assistNumber;

    /**
     * 辅助单位名
     */
    String assistUnitName;

    /**
     * 仓单号
     */
    String whReceiptId;

    /**
     * 选货批次号
     */
    String selectBatchNo;

}
