package com.group3.fundmgt.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundService {
    private final FundRepository fundRepository;

    @Autowired
    public FundService(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    // 1.查：获取所有数据
    public List<Fund> getFund(){return fundRepository.findAll();}

    // 2.查：根据id查询记录
    public Fund getFund(Long fundId){
        Optional<Fund> fund = fundRepository.findById(fundId);
        if (fund.isEmpty()){
            throw new FundNotFoundException(fundId);
        }
        return fund.get();
    }

    // 3.增加记录
    public List<Fund> addFund(String fundName) {
        Fund fund = new Fund(fundName);
        fundRepository.save(fund);
        return fundRepository.findAll();
    }

    // 4.根据id，删除记录
    public List<Fund> deleteById(Long fundId) {
        fundRepository.deleteById(fundId);
        return fundRepository.findAll();
    }

    // 5.多表查询，涉及到join相关操作

}
