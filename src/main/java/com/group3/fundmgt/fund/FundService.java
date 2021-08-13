package com.group3.fundmgt.fund;

import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerNotFoundException;
import com.group3.fundmgt.position.PositionNotFoundException;
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
    public void addFund(Fund fund) {
        fundRepository.save(fund);
    }

    // 4.根据id，删除记录
    public void deleteById(Long fundId) {
        if(fundRepository.existsById(fundId)){
            fundRepository.deleteById(fundId);
        }
        else{
            throw new FundNotFoundException(fundId);
        }
    }

    // 5.update
    public void updateFund(Long id, Fund f) {
        Optional<Fund> fundToUpdateOptional = this.fundRepository.findById(id);
        if (!fundToUpdateOptional.isPresent()) {
            throw new ManagerNotFoundException(id);
        }

        Fund fundToUpdate = fundToUpdateOptional.get();
        if (fundToUpdate.getFundId() != null && fundToUpdate.getFundId() != f.getFundId()){
            //TODO USe custom exception.
            throw new IllegalStateException("FundId in path and in request body are different.");
        }
        if(f.getName()!=null){
            fundToUpdate.setName(f.getName());
        }
        this.fundRepository.save(fundToUpdate);
    }

}
