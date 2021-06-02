package com.nick.springboot.mapper;

import com.nick.springboot.entity.StockInDetailPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zwj
 * @date 2021/6/1
 */
@Repository
public interface StockInDetailPoMapper {

    List<StockInDetailPO> findAllByParentId(String parentId);
}
