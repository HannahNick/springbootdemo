package com.nick.springboot.service.impl;

import com.nick.springboot.dto.IncreaseCreditLineRecordRequestDTO;
import com.nick.springboot.dto.PageDTO;
import com.nick.springboot.entity.IncreaseCreditLineRecord;
import com.nick.springboot.mapper.IncreaseCreditLineRecordMapper;
import com.nick.springboot.service.IncreaseCreditLineRecordService;
import com.nick.springboot.vo.IncreaseCreditLineSumInfoVo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwj
 * @date 2021/7/11
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class IncreaseCreditLineRecordServiceImpl implements IncreaseCreditLineRecordService {

    IncreaseCreditLineRecordMapper increaseCreditLineRecordMapper;


    @Override
    public PageDTO<IncreaseCreditLineRecord> selectIncreaseCreditLineRecordPage(IncreaseCreditLineRecordRequestDTO increaseCreditLineRecordRequestDTO) {
        List<IncreaseCreditLineRecord> increaseCreditLineRecords = increaseCreditLineRecordMapper.selectAllByCondition(increaseCreditLineRecordRequestDTO);
        return new PageDTO<>(increaseCreditLineRecords,0,0,0);
    }

    @Override
    public List<String> selectAllProductCode() {
        return increaseCreditLineRecordMapper.selectAllProductCode();
    }

    @Override
    public IncreaseCreditLineSumInfoVo selectSumInfo() {
        return increaseCreditLineRecordMapper.selectSumInfo();
    }
}
