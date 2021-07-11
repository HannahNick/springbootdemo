package com.nick.springboot.service;

import com.nick.springboot.dto.IncreaseCreditLineRecordRequestDTO;
import com.nick.springboot.dto.PageDTO;
import com.nick.springboot.entity.IncreaseCreditLineRecord;
import com.nick.springboot.vo.IncreaseCreditLineSumInfoVo;

import java.util.List;

/**
 * @author zwj
 * @date 2021/7/11
 */
public interface IncreaseCreditLineRecordService {

    /**
     * 分页查询提额记录
     * @param increaseCreditLineRecordRequestDTO dto
     * @return page
     */
    PageDTO<IncreaseCreditLineRecord> selectIncreaseCreditLineRecordPage(IncreaseCreditLineRecordRequestDTO increaseCreditLineRecordRequestDTO);

    /**
     * 查询所有的产品号类型
     * @return 产品号类型
     */
    List<String> selectAllProductCode();

    /**
     * 查询统计数据
     * @return
     */
    IncreaseCreditLineSumInfoVo selectSumInfo();

}
