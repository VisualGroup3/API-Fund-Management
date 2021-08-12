package com.group3.fundmgt.manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManagerNotFoundException extends IllegalArgumentException {
    private final Long employeeId;

    public ManagerNotFoundException(Long employeeId) {
        super("Fund manager with employee id " + employeeId + " not found.");
        this.employeeId = employeeId;
    }
}
