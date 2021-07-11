package com.nick.springboot.controller;

import com.nick.springboot.dto.IncreaseCreditLineRecordRequestDTO;
import com.nick.springboot.dto.Order;
import com.nick.springboot.dto.PageDTO;
import com.nick.springboot.entity.IncreaseCreditLineRecord;
import com.nick.springboot.service.IncreaseCreditLineRecordService;
import com.nick.springboot.vo.IncreaseCreditLineSumInfoVo;
import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zwj
 * @date 2021/7/11
 */
@RestController
@RequestMapping(value = "/increaseCreditLineRecord", produces = MediaType.APPLICATION_JSON_VALUE)
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class IncreaseCreditLineRecordController {

    IncreaseCreditLineRecordService increaseCreditLineRecordService;

    @PostMapping("/selectIncreaseCreditLineRecordPage")
    public PageDTO<IncreaseCreditLineRecord> selectIncreaseCreditLineRecordPage(@RequestBody IncreaseCreditLineRecordRequestDTO increaseCreditLineRecordRequestDTO){
        return increaseCreditLineRecordService.selectIncreaseCreditLineRecordPage(increaseCreditLineRecordRequestDTO);
    }

    @GetMapping("/selectAllProductCode")
    public List<String> selectAllProductCode(){
        return increaseCreditLineRecordService.selectAllProductCode();
    }

    @GetMapping("/selectSumInfo")
    public IncreaseCreditLineSumInfoVo selectSumInfo(){
        return increaseCreditLineRecordService.selectSumInfo();
    }
}
