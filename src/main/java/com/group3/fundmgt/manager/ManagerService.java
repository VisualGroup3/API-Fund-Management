package com.group3.fundmgt.manager;

import com.group3.fundmgt.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;


    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers() {
        return this.managerRepository.findAll();
    }

    // GET request handler
    public Manager getManager(Long employeeId) {
        Optional<Manager> manager = this.managerRepository.findById(employeeId);
        if (manager.isEmpty()) {
            throw new ManagerNotFoundException(employeeId);
        }
        return manager.get();
    }

    // POST request handler
    public Manager createNewManager(Manager manager) {
        Manager newManager = this.managerRepository.save(manager);
        return newManager;
    }

    // PUT request handler
    public Manager updateManager(Long id, Manager m) {
        Optional<Manager> managerToUpdateOptional = this.managerRepository.findById(id);
        if (!managerToUpdateOptional.isPresent()) {
            return null;
        }
        Manager managerToUpdate = managerToUpdateOptional.get();
        if (m.getFirstName() != null) {
            managerToUpdate.setFirstName(m.getFirstName());
        }
        if (m.getLastName() != null) {
            managerToUpdate.setLastName(m.getLastName());
        }
        Manager updatedManager = this.managerRepository.save(managerToUpdate);
        return updatedManager;
    }

    // DELETE request handler
    public Manager deleteManager(Long employeeId) {
        Optional<Manager> managerToDeleteOptional = this.managerRepository.findById(employeeId);
        if (!managerToDeleteOptional.isPresent()) {
            return null;
        }
        Manager managerToDelete = managerToDeleteOptional.get();
        this.managerRepository.delete(managerToDelete);
        return managerToDelete;
    }




}
