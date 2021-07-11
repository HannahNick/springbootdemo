package com.nick.springboot.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhangyx
 * @create 2020-04-26 10:41
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageDTO<T> implements Serializable {

    static final long serialVersionUID = 6268718986881793567L;

    long totalElements;

    int totalPages;

    int number;

    List<T> rows = new ArrayList<>();

    public PageDTO() {

    }

    public PageDTO(List<T> content, long totalElements, int totalPages, int number) {
        Assert.notNull(content, "Content must not be null!");
        this.rows.addAll(content);
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }

    public PageDTO(long totalElements, int totalPages, int number, List<T> content) {
        Assert.notNull(content, "Content must not be null!");
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number + 1;
        if (this.number > this.totalPages) {
            this.number = this.totalPages;
        }
        this.rows.addAll(content);
    }


    public void rowProcess(Consumer<T> consumer) {
        if (!CollectionUtils.isEmpty(this.rows)) {
            this.rows.forEach(consumer);
        }
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    @JSONField(name = "pageCount")
    @JsonGetter("pageCount")
    public int getTotalPages() {
        return totalPages;
    }

    @JSONField(name = "pageCount")
    @JsonSetter("pageCount")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @JSONField(name = "currentNo")
    @JsonGetter("currentNo")
    public int getNumber() {
        return number;
    }

    @JSONField(name = "currentNo")
    @JsonSetter("currentNo")
    public void setNumber(int number) {
        this.number = number;
    }

}

