package com.group3.fundmgt.manager;

import com.group3.fundmgt.position.Position;
import com.group3.fundmgt.position.PositionNotFoundException;
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
    public void createNewManager(Manager manager) {
        this.managerRepository.save(manager);
    }

    // PUT request handler
    public void updateManager(Long id, Manager m) {
        Optional<Manager> managerToUpdateOptional = this.managerRepository.findById(id);
        if (!managerToUpdateOptional.isPresent()) {
            throw new ManagerNotFoundException(id);
        }
        Manager managerToUpdate = managerToUpdateOptional.get();
        if (managerToUpdate.getEmployeeId() != null && managerToUpdate.getEmployeeId() != m.getEmployeeId()){
            //TODO USe custom exception.
            throw new IllegalStateException("EmployeeId in path and in request body are different.");
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
    public void deleteManager(Long employeeId) {
        if(this.managerRepository.existsById(employeeId)){
            this.managerRepository.deleteById(employeeId);
        }
        else{
            throw new ManagerNotFoundException(employeeId);
        }
    }




}
