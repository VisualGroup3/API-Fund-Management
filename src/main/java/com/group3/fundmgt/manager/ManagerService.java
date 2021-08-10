package com.group3.fundmgt.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers() {
        return managerRepository.findAll();
    }

    public Manager getManager(Integer employeeId) {
        Optional<Manager> manager = managerRepository.findById(employeeId);
        if (manager.isEmpty()) {
            throw new ManagerNotFoundException(employeeId);
        }
        return manager.get();
    }
}
