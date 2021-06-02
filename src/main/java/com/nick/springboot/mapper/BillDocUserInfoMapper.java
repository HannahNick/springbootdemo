package com.nick.springboot.mapper;

import com.nick.springboot.entity.BillDocUserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author zwj
 * @date 2021/5/31
 */
@Repository
public interface BillDocUserInfoMapper {

    BillDocUserInfo findByBillDocNo(String billDocNo);
}
