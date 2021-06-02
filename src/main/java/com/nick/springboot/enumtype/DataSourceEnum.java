package com.nick.springboot.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName DataSourceEnum
 * Description 数据来源枚举(特指订单数据来源)
 * @author lym
 * date 2020/7/31 15:27
 */
@Getter
@AllArgsConstructor
public enum DataSourceEnum implements IPairs<String, String, DataSourceEnum> {
    /**
     * 人工创建
     */
    SCM("SCM", "人工创建"),

    /**
     * 云仓
     */
    //WMS("WMS", "云仓"),

    /**
     * 沐甜商城
     */
    M_SWEET("M_SWEET", "沐甜商城"),

    /**
     * 沐甜商城自营
     */
    M_SWEET_SELF("M_SWEET_SELF", "沐甜商城自营"),

    /**
     * 茧丝商城
     */
    JS_SHOP("JS_SHOP", "茧丝商城"),

    /**
     * 在线贸易
     */
    ZXMY("ZXMY", "在线贸易"),

    /**
     * 资金系统
     */
    FUNDING_SYSTEM("FUNDING_SYSTEM", "资金系统"),

    /**
     * 结算系统
     */
    SETTLEMENT_SYSTEM("SETTLEMENT_SYSTEM", "结算系统");

    /**
     * 代码
     */
    String code;

    /**
     * 名称
     */
    String name;


    @Override
    public DataSourceEnum get() {
        return this;
    }

    /**
     * 获取代码
     *
     * @return 代码
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
    @Override
    public String getName() {
        return this.name;
    }
}
