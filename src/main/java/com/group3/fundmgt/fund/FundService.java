package com.group3.fundmgt.fund;

import com.alibaba.fastjson.JSONObject;
import com.group3.fundmgt.exception.BadRequestException;
import com.group3.fundmgt.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public Fund getFund(String fundId){
        Optional<Fund> fund = fundRepository.findById(fundId);
        if (fund.isEmpty()){
            throw new NotFoundException("Fund  with  fundID " + fundId + " not found.");
        }
        return fund.get();
    }

    // 3.增加记录
    public void addFund(Fund fund) {
        fundRepository.save(fund);
    }

    // 4.根据id，删除记录
    public void deleteById(String fundId) {
        if(fundRepository.existsById(fundId)){
            fundRepository.deleteById(fundId);
        }
        else{
            throw new NotFoundException("Fund  with  fundID " + fundId + " not found.");
        }
    }

    // 5.update
    public void updateFund(String id, Fund f) {
        Optional<Fund> fundToUpdateOptional = this.fundRepository.findById(id);
        if (!fundToUpdateOptional.isPresent()) {
            throw new NotFoundException("Fund  with  fundID " + id + " not found.");
        }

        Fund fundToUpdate = fundToUpdateOptional.get();
        if (fundToUpdate.getFundId() != null && fundToUpdate.getFundId() != f.getFundId()){
            //TODO USe custom exception.
            throw new BadRequestException("FundId in path and in request body are different.");
        }
        if(f.getName()!=null){
            fundToUpdate.setName(f.getName());
        }
        this.fundRepository.save(fundToUpdate);
    }

    public List<FundAssetValue> getFundValueByAsset(String fundId){
        List list=fundRepository.getValueGroupByAssetClass(fundId);
        List<FundAssetValue> fundAssetValueList=new ArrayList<>();
        for(Object row:list){
            FundAssetValue fundAssetValue=new FundAssetValue();
            Object[] cells = (Object[]) row;
            fundAssetValue.setAssetClass(String.valueOf(cells[1]));
            BigDecimal bigDecimal=new BigDecimal(String.valueOf(cells[0]));
            fundAssetValue.setValue(bigDecimal.longValue());
            fundAssetValueList.add(fundAssetValue);
        }

        return fundAssetValueList;
    }

}
