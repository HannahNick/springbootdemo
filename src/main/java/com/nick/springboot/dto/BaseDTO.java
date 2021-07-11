package com.nick.springboot.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * 类 编 号：
 * 类 名 称：分页需要继承改BaseDTO
 * 内容摘要：抽象出公用属性
 * 创建日期：2016/10/25
 *
 * @author huangchenliang
 */
@Data
public abstract class BaseDTO implements Serializable {

    /**
     * 主键ID
     */
    String id;

    /**
     * 分页数
     */
    private int pageNumber;

    /**
     * 当前页
     */
    private int currentNo;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 排序类型
     */
    private String sortType;

    /**
     * 获取 分页数
     */
    public Integer getPageNumber() {
        return this.pageNumber;
    }

    /**
     * 设置 分页数
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.currentNo = pageNumber;
    }

    /**
     * 获取 分页大小
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 排序类型
     */
    public String getSortType() {
        return this.sortType;
    }

    /**
     * 设置 排序类型
     */
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public Integer getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(Integer currentNo) {
        this.currentNo = currentNo;
        this.pageNumber = currentNo;
    }

}
