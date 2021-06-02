package com.nick.springboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nick.springboot.enumtype.DataSourceEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 入库表
 *
 * @author zwj
 * @date 2020/7/22
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockInPO{

    String id;

    /**
     * 入库单编号
     */
    String stockInNo;

    /**
     * 来源单号
     */
    String sourceNo;

    /**
     * 入库类型
     */
//    StockInTypeEnum type;

    /**
     * 入库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date inTime;

    /**
     * 入库状态
     */
//    StockInStatusEnum inStatus;

    /**
     * 用户id
     */
    String customerUserId;

    /**
     * 客户id
     */
    String customerId;

    /**
     * 用户名
     */
    String customerName;

    /**
     * 客户号
     */
    String customerAccount;

    /**
     * 市场人员编号
     */
    String marketerNo;

    /**
     * 市场人员名称
     */
    String marketerName;

    /**
     * 业务日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date businessTime;

    /**
     * 总金额
     */
    BigDecimal totalAmount;

    /**
     * 总金额(不含税)
     */
    BigDecimal totalAmountExcludeTax;

    /**
     * 总数量
     */
    BigDecimal totalNumber;

    /**
     * 币种
     */
    String currency;

    /**
     * 业务仓库id
     */
    String businessStockroomCode;

    /**
     * 业务仓库名
     */
    String businessStockroomName;

    /**
     * 仓库id
     */
    String stockroomId;

    /**
     * 仓库名
     */
    String stockroomName;

    /**
     * 仓库类型
     */
    String stockroomType;

    /**
     * 仓库地址
     */
    String stockroomAddress;

    /**
     * wms任务id
     */
    String taskId;

    /**
     * 仓单id
     */
    String whReceiptId;

    /**
     * 附件链接
     */
    String enclosureUrl;

    /**
     * 父订单号
     */
    String parentOrderNo;

    /**
     * 订单号
     */
    String orderNo;

    /**
     * 合同编号
     */
    String contractNo;

    /**
     * 订单类型
     */
//    SourceOrderTypeEnum orderType;

    /**
     * 数据来源
     */
    DataSourceEnum dataSource;

    /**
     * 订单标签
     */
    String tag;

    /**
     * 市场id
     */
    String marketId;

    /**
     * 用户信息
     */
    BillDocUserInfo billDocUserInfo;

    /**
     * 入库单明细
     */
    List<StockInDetailPO> stockInDetailPos;

}
