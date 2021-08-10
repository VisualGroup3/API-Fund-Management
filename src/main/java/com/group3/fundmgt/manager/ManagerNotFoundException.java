package com.group3.fundmgt.manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManagerNotFoundException extends IllegalArgumentException {
    private final Integer employeeId;

    public ManagerNotFoundException(Integer employeeId) {
        super("Fund manager with employee id " + employeeId + " not found.");
        this.employeeId = employeeId;
    }
}
