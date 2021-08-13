package com.group3.fundmgt.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/managers")
public class ManagerController {
    private final ManagerService managerService;


    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    
    @GetMapping 
    public List<Manager> getManager() {
        return managerService.getManagers();
    }
    
    @GetMapping("/getManager/{employeeId}")
    public Manager getManager(@PathVariable("employeeId") Long employeeId) {
        return managerService.getManager(employeeId);
    }

    @PostMapping(path="/createNewManager")
    public Manager createNewManager(@RequestBody Manager manager) {
        return managerService.createNewManager(manager);
    }

    @PutMapping("/updateManager/{employeeId}")
    public Manager updateManager(@PathVariable("employeeId") Long employeeId,
                              @RequestBody Manager manager) {
        return managerService.updateManager(employeeId, manager);
    }

    @DeleteMapping("/deleteManager/{employeeId}")
    public Manager deleteManager(@PathVariable("employeeId") Long employeeId) {
        return managerService.deleteManager(employeeId);
    }

}
