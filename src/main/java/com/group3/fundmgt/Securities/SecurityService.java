package com.group3.fundmgt.Securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityService {

    private final SecurityRepository repo;

    @Autowired
    public SecurityService(SecurityRepository repo) {
        this.repo = repo;
    }

    public List<Security> listAll(){
        return repo.findAll();
    }
    public void save(Security security){
        repo.save(security);
    }

    public Security get(Integer securityId){
        Optional<Security> security = repo.findById(securityId);
        if (security.isEmpty()) {
            throw new SecurityNotFoundException(securityId);
        }
        return security.get();
    }

    public  void delete(Integer securityId){
        repo.deleteById(securityId);
    }
}
