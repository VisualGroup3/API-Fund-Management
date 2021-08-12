package com.group3.fundmgt.Securities;

import com.group3.fundmgt.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/securities")
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    //Restful API for Retrieval Operation
    @GetMapping(path="/getSecurities")
    public List<Security> listSecurity(){
        List<Security> s = securityService.listAll();
        return s;
    }

    @GetMapping(path="/getSecurities/{securityId}")
    public Security getSecurities(@PathVariable("securityId") Integer id) {
        return securityService.get(id);
    }

    //Create
    @PostMapping(path="/createSecurity")
    public void createSecurity(@RequestBody Security security){
        securityService.save(security);
    }

    //update
    @PutMapping(path="/updateSecurities/{securityId}")
    public List<Security> updateSecurities(@RequestBody Security security, @PathVariable("securityId") Integer id){
        Security existSecurity = securityService.get(id);
        if(security.getSecurityId() == existSecurity.getSecurityId()){
            existSecurity.setSymbol(security.getSymbol());
        }
        return securityService.listAll();
    }

    //delete
    @DeleteMapping(path="/deleteSecurity/{securityId}")
    public List<Security> deleteSecurity(@PathVariable("securityId") Integer id){
        securityService.delete(id);
        System.out.println("delete successfully");
        return securityService.listAll();
    }

}
