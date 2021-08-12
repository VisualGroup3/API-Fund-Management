package com.group3.fundmgt.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/managers")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    
    @GetMapping 
    public List<Manager> getManager() {
        return managerService.getManagers();
    }
    
    @GetMapping(path="{employeeId}")
    public Manager getManager(@PathVariable("employeeId") Long employeeId) {
        return managerService.getManager(employeeId);
    }
}
