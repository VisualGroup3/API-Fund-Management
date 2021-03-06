package com.group3.fundmgt.fund;

import com.alibaba.fastjson.JSONObject;
import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.List;

@CrossOrigin
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
    public Fund getFund(@PathVariable("fundId") String fundId){
        System.out.println(fundService.getFund(fundId).toString());
        return fundService.getFund(fundId);
    }

    // 3.增加记录
    @PostMapping
    public void addFund(@RequestBody Fund fund){

        System.out.println(fund.toString());
        fundService.addFund(fund);
    }


    // 4.根据id，删除记录
    @DeleteMapping(value = "{fundId}")
    public void deleteById(@PathVariable("fundId") String fundId){
         fundService.deleteById(fundId);

    }

    @PutMapping("{fundId}")
    public void updateFund(@PathVariable("fundId") String id,
                              @RequestBody Fund fund) {
        fundService.updateFund(id, fund);
    }

    @GetMapping(value = "{fundId}/value")
    public JSONObject getFundValueByAsset(@PathVariable("fundId") String id){
        List<FundAssetValue> fundAssetValueList=fundService.getFundValueByAsset(id);
        List<FundSecurityValue> fundSecurityValueList=fundService.getFundValueBySecurity(id);
        long totalValue=0;
        for(FundAssetValue v:fundAssetValueList){
            totalValue+=v.getValue();
        }
        JSONObject result=new JSONObject();
        Fund fund=fundService.getFund(id);
        result.put("fund",fund);
        result.put("assetsValue",fundAssetValueList);
        result.put("securityValue",fundSecurityValueList);
        result.put("totalValue",totalValue);
        System.out.println(result.toJSONString());
        return result;
    }
}
