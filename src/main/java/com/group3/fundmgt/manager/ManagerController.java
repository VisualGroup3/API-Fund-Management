package com.group3.fundmgt.manager;


import com.alibaba.fastjson.JSONObject;
import com.group3.fundmgt.fund.Fund;
import com.group3.fundmgt.fund.FundAssetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;
    
    @GetMapping 
    public List<Manager> getManager() {
        return managerService.getManagers();
    }
    
    @GetMapping("{employeeId}")
    public Manager getManager(@PathVariable("employeeId") String employeeId) {
        return managerService.getManager(employeeId);
    }


    @PostMapping
    public void createNewManager(@RequestBody Manager manager) {
         managerService.createNewManager(manager);
    }

    @PutMapping("{employeeId}")
    public void updateManager(@PathVariable("employeeId") String employeeId, @RequestBody Manager manager) {
         managerService.updateManager(employeeId, manager);
    }


    @DeleteMapping("{employeeId}")
    public void deleteManager(@PathVariable("employeeId") String employeeId) {
         managerService.deleteManager(employeeId);

    }

    @GetMapping(value = "{employeeId}/value")
    public JSONObject getManagerValueByAsset(@PathVariable("employeeId") String employeeId){
        List<ManagerAssetValue> managerAssetValueList=managerService.getManagerValueByAsset(employeeId);
        long totalValue=0;
        for(ManagerAssetValue v:managerAssetValueList){
            totalValue+=v.getValue();
        }
        JSONObject result=new JSONObject();
        Manager manager=managerService.getManager(employeeId);
        result.put("manager",manager);
        result.put("assetsValue",managerAssetValueList);
        result.put("totalValue",totalValue);
        System.out.println(result.toJSONString());
        return result;
    }
}
