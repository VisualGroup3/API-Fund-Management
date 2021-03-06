package com.group3.fundmgt.manager;

import com.alibaba.fastjson.JSONObject;
import com.group3.fundmgt.exception.BadRequestException;
import com.group3.fundmgt.exception.NotFoundException;
import com.group3.fundmgt.fund.Fund;
import com.group3.fundmgt.fund.FundAssetValue;
import com.group3.fundmgt.fund.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    FundService fundService;
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers() {
        return this.managerRepository.findAll();
    }

    // GET request handler
    public Manager getManager(String employeeId) {
        Optional<Manager> manager = this.managerRepository.findById(employeeId);
        if (manager.isEmpty()) {
            throw new NotFoundException("Fund manager with employeeID " + employeeId + " not found.");
        }
        return manager.get();
    }

    // POST request handler
    public void createNewManager(Manager manager) {
        this.managerRepository.save(manager);
    }

    // PUT request handler
    public void updateManager(String id, Manager m) {
        Optional<Manager> managerToUpdateOptional = this.managerRepository.findById(id);
        if (!managerToUpdateOptional.isPresent()) {
            throw new NotFoundException("Fund manager with employeeID " + id + " not found.");
        }
        Manager managerToUpdate = managerToUpdateOptional.get();
        if (managerToUpdate.getEmployeeId() != null && managerToUpdate.getEmployeeId() != m.getEmployeeId()){
            //TODO USe custom exception.
            throw new BadRequestException("employeeID in path and in request body are different.");
        }

        if (m.getFirstName() != null) {
            managerToUpdate.setFirstName(m.getFirstName());
        }
        if (m.getLastName() != null) {
            managerToUpdate.setLastName(m.getLastName());
        }
        this.managerRepository.save(managerToUpdate);
    }

    // DELETE request handler
    public void deleteManager(String employeeId) {
        if(this.managerRepository.existsById(employeeId)){
            this.managerRepository.deleteById(employeeId);
        }
        else{
            throw new NotFoundException("Fund manager with employeeID " + employeeId + " not found.");
        }
    }

    public List<ManagerAssetValue> getManagerValueByAsset(String employeeId){
        List list=managerRepository.getValueGroupByAssetClass(employeeId);
        List<ManagerAssetValue> managerAssetValueList=new ArrayList<>();
        for(Object row:list){
            ManagerAssetValue managerAssetValue=new ManagerAssetValue();
            Object[] cells = (Object[]) row;
            managerAssetValue.setAssetClass(String.valueOf(cells[1]));
            BigDecimal bigDecimal=new BigDecimal(String.valueOf(cells[0]));
            managerAssetValue.setValue(bigDecimal.longValue());
            managerAssetValueList.add(managerAssetValue);
        }
        return managerAssetValueList;
    }


}
