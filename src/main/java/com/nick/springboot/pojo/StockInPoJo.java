package com.nick.springboot.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author zwj
 * @date 2021/5/31
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockInPoJo {

    String id;
    String stockInNo;
    String sourceNo;
    String enableFlag;
    Date startTime;
    Date endTime;
    String orgId;
    String customerAccount;
    String customerName;
}
