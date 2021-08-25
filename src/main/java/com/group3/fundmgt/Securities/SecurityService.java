package com.group3.fundmgt.Securities;

import com.group3.fundmgt.exception.BadRequestException;
import com.group3.fundmgt.exception.NotFoundException;
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
        Optional<Security> securityOptional=repo.findSecuritiesBySymbol(security.getSymbol());
        if(!securityOptional.isEmpty()){
            throw new BadRequestException("security with symbol "+security.getSymbol()+" already existed");
        }
        repo.save(security);
    }

    public Security get(String symble){
        Optional<Security> security = repo.findById(symble);
        if (security.isEmpty()) {
            throw new NotFoundException("Security  with symble " + symble + " not found.");
        }
        return security.get();
    }

    public  void delete(String symble){
        repo.deleteById(symble);
    }
}
