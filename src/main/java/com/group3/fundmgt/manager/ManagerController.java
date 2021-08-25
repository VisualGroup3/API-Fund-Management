package com.group3.fundmgt.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/managers")
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

}
