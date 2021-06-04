package com.nick.springboot;

import com.github.pagehelper.PageHelper;
import com.nick.springboot.entity.StockInPO;
import com.nick.springboot.mapper.StockInPoMapper;
import com.nick.springboot.pojo.StockInPoJo;
import com.nick.springboot.util.DateUtils;
import com.nick.springboot.util.JsonUtils;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
class SpringbootApplicationTests {

    @Autowired
    StockInPoMapper stockInPoMapper;

    @Test
    void testMybatis() {
        StockInPO stockInPO = stockInPoMapper.findById("628771835901506");
        System.out.println(stockInPO);
        System.out.println(stockInPO.getStockInDetailPos());
    }

    @Test
    void testInsert() {
        StockInPO stockInPO = new StockInPO();
        stockInPO.setId("628771835884891");
        stockInPO.setStockInNo("WSI21201202011884891");
        stockInPO.setSourceNo("PO21201202011884891");
        boolean insert = stockInPoMapper.insert(stockInPO);
        System.out.println(insert);
    }

    @Test
    void testUpdate() {
        StockInPO stockInPO = new StockInPO();
        stockInPO.setId("628771835884891");
        stockInPO.setStockInNo("WSI21201202011884123");
        stockInPO.setSourceNo("PO21201202011884891");
        boolean update = stockInPoMapper.update(stockInPO);
        System.out.println(update);
    }

    @Test
    void testUpdateByCondition(){
        StockInPO stockInPO = new StockInPO();
        stockInPO.setId("628771835884891");
        stockInPO.setStockInNo("WSI212");
        stockInPO.setSourceNo("PO2124");
        boolean update = stockInPoMapper.updateByConditionSet(stockInPO);
        System.out.println(update);
    }

    @Test
    void testDelete(){
        boolean delete = stockInPoMapper.deleteById("628771835884891");
        System.out.println(delete);
    }

    @Test
    void testMulParameter(){
        StockInPO stockInPO = stockInPoMapper.findByStockInNoAndEnableFlag("WSI21201202011270010", "Y");
        System.out.println(stockInPO);
    }

    @Test
    void testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("stockInNo","WSI21201202011270010");
        map.put("enableFlag","Y");
        map.put("tableName","stock_in");
        StockInPO byMap = stockInPoMapper.findByMap(map);
        System.out.println(JsonUtils.toJSONString(byMap));
    }

    @Test
    void testPoJo(){
        StockInPoJo stockInPoJo = new StockInPoJo();
        stockInPoJo.setStockInNo("WSI21201202011270010");
        stockInPoJo.setEnableFlag("Y");
        StockInPO stockInPO = stockInPoMapper.findByPoJo(null, stockInPoJo);
        System.out.println(stockInPO);
    }

    @Test
    void testList(){
        StockInPoJo stockInPoJo = new StockInPoJo();
        stockInPoJo.setSourceNo("PC21201202011270001");
        stockInPoJo.setEnableFlag("N");
        List<StockInPO> stockInPOS = stockInPoMapper.findAllBySourceNoAndEnableFlag(stockInPoJo);
        stockInPOS.forEach(System.out::println);
    }

    @Test
    void testFindByIdResultMap(){
        Map<String, Object> result = stockInPoMapper.findByIdResultMap("629051752674438");
        System.out.println(result);
    }

    @Test
    void testFindAllBySourceNoGroupResultMap(){
        StockInPoJo stockInPoJo = new StockInPoJo();
        stockInPoJo.setSourceNo("PC21201202011270001");
        stockInPoJo.setEnableFlag("N");
        Map<String, StockInPO> map = stockInPoMapper.findAllBySourceNoGroupResultMap(stockInPoJo);
        System.out.println(map);
    }

    @Test
    void testMulTableSelect(){
        StockInPO stockInPO = stockInPoMapper.findByBillDocNo("WSI21201202011270001");
        System.out.println(stockInPO);
    }

    @Test
    void testMulTableSelect2(){
        StockInPO stockInPO = stockInPoMapper.findByBillDocNo2("WSI21201202011270001");
        System.out.println(stockInPO.getContractNo());
        System.out.println(stockInPO.getBillDocUserInfo());
    }

    @Test
    void testFindAllByConditionIf(){
        StockInPoJo stockInPoJo = new StockInPoJo();
        stockInPoJo.setEnableFlag("Y");
        stockInPoJo.setSourceNo("WT21201202011260003");
        stockInPoJo.setStockInNo("WSI21201202011260024");
        stockInPoJo.setId("628781757056583");
        List<StockInPO> stockInPOS = stockInPoMapper.findByConditionIf(stockInPoJo);
        System.out.println(stockInPOS);
    }

    @Test
    void testFindAllByConditionChoose(){
        StockInPoJo stockInPoJo = new StockInPoJo();
//        stockInPoJo.setEnableFlag("Y");
//        stockInPoJo.setSourceNo("WT21201202011260003");
//        stockInPoJo.setStockInNo("WSI21201202011260024");
//        stockInPoJo.setId("628781757056583");
        PageHelper.startPage(1, 10);
        List<StockInPO> stockInPOS = stockInPoMapper.findByConditionChoose(stockInPoJo);
        System.out.println(JsonUtils.toJSONString(stockInPOS));
    }

    @Test
    void testFindByIn(){
        List<StockInPO> stockIns = stockInPoMapper.findByIdIn(Arrays.asList("6287718358848910", "6287718358848911", "6287718358848912","6287718358848913","6287718358848914"));
        System.out.println(stockIns);
    }

    @Test
    void testInsertForeach(){
        List<StockInPO> stockIns = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StockInPO stockInPO = new StockInPO();
            stockInPO.setId("628771835884891".concat(String.valueOf(i)));
            stockInPO.setStockInNo("WSI628771835884891".concat(String.valueOf(i)));
            stockInPO.setSourceNo("PC628771835884891".concat(String.valueOf(i)));
            stockIns.add(stockInPO);
        }
        stockInPoMapper.insertAll(stockIns);
    }

    @Test
    void findAllPage(){
        PageHelper.startPage(1,5);
        StockInPoJo stockInPoJo = new StockInPoJo();
        Date start = DateUtils.formatDates("2020-11-26 00:00:00", DateUtils.FORMAT_DATE_TIME);
        Date end = DateUtils.formatDates("2020-11-30 10:12:19", DateUtils.FORMAT_DATE_TIME);
        stockInPoJo.setStartTime(start);
        stockInPoJo.setEndTime(end);
        List<StockInPO> allPage = stockInPoMapper.findAllPage(stockInPoJo);
        System.out.println(JsonUtils.toJSONString(allPage));
    }

}
