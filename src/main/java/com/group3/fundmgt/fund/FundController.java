package com.group3.fundmgt.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/funds")
public class FundController {
    private final FundService fundService;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    // 1.查：获取所有数据
    @GetMapping
    public List<Fund> getFund(){return fundService.getFund();}

    // 2.查：根据id查询记录
    @GetMapping(value = "{fundId}")
    public Fund getFund(@PathVariable("fundId") Long fundId){
        return fundService.getFund(fundId);
    }

    // 3.增加记录
    @PostMapping(value = "{fundName}")
    public List<Fund> addFund(@PathVariable("fundName") String fundName){
        return fundService.addFund(fundName);
    }

    // 4.根据id，删除记录
    @DeleteMapping(value = "{fundId}")
    public List<Fund> deleteById(@PathVariable("fundId") Long fundId){
        return fundService.deleteById(fundId);
    }

    // 5.多表查询，涉及到join相关操作
}
