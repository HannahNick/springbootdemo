package com.nick.springboot.mapper;

import com.nick.springboot.dto.IncreaseCreditLineRecordRequestDTO;
import com.nick.springboot.entity.IncreaseCreditLineRecord;
import com.nick.springboot.vo.IncreaseCreditLineSumInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zwj
 * @date 2021/7/11
 */
@Repository
public interface IncreaseCreditLineRecordMapper {

    /**
     * 条件分页查询
     * @return
     */
    List<IncreaseCreditLineRecord> selectAllByCondition(IncreaseCreditLineRecordRequestDTO increaseCreditLineRecordRequestDTO);

    /**
     * 查询所有状态
     * @return
     */
    List<String> selectAllProductCode();

    /**
     * 查询统计额外信息
     */
    IncreaseCreditLineSumInfoVo selectSumInfo();

}
