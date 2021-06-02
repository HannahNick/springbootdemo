package com.nick.springboot.mapper;

import com.nick.springboot.entity.StockInPO;
import com.nick.springboot.pojo.StockInPoJo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zwj
 * @date 2021/5/30
 */
@Repository
public interface StockInPoMapper {

    StockInPO findById(String id);

    StockInPO findByStockInNoAndEnableFlag(@Param("stockInNo") String stockInNo, @Param("enableFlag") String enableFlag);

    StockInPO findByMap(Map<String,Object> map);

    StockInPO findByPoJo(@Param("id") String id,@Param("stockIn") StockInPoJo stockInPoJo);

    List<StockInPO> findAllBySourceNoAndEnableFlag(StockInPoJo stockInPoJo);

    Map<String,Object> findByIdResultMap(String id);

    @MapKey("id")
    Map<String,StockInPO> findAllBySourceNoGroupResultMap(StockInPoJo stockInPoJo);

    boolean insert(StockInPO stockInPO);

    boolean update(StockInPO stockInPO);

    boolean updateByConditionSet(StockInPO stockInPO);

    boolean deleteById(String id);

    /**
     * 联表查询
     */
    StockInPO findByBillDocNo(String stockInNo);

    /**
     * 联表查询2
     */
    StockInPO findByBillDocNo2(String stockInNo);


    List<StockInPO> findByConditionIf(StockInPoJo stockInPoJo);

    List<StockInPO> findByConditionChoose(StockInPoJo stockInPoJo);

    List<StockInPO> findByIdIn(@Param("ids") List<String> aaa);

    boolean insertAll(@Param("stockInPos") List<StockInPO> stockInPOS);
}
