package com.group3.fundmgt.Securities;

import com.group3.fundmgt.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/securities")
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    //Restful API for Retrieval Operation
    @GetMapping
    public List<Security> listSecurity(){
        return securityService.listAll();
    }

    @GetMapping(path="{symble}")
    public Security getSecurities(@PathVariable("symble") String symble) {
        return securityService.get(symble);
    }

    //Create
    @PostMapping
    public void createSecurity(@RequestBody Security security){
        securityService.save(security);
    }

    //update
    @PutMapping(path="{symble}")
    public List<Security> updateSecurities(@RequestBody Security security, @PathVariable("symble") String symble){
        Security existSecurity = securityService.get(symble);
        if(security.getSymbol() == existSecurity.getSymbol()){
            existSecurity.setSymbol(security.getSymbol());
        }
        return securityService.listAll();
    }

    //delete
    @DeleteMapping(path="{securityId}")
    public List<Security> deleteSecurity(@PathVariable("securityId") String symble){
        securityService.delete(symble);
        System.out.println("delete successfully");
        return securityService.listAll();
    }

}
