package com.group3.fundmgt.Securities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SecurityNotFoundException extends IllegalArgumentException{
    private final Integer securityId;


    public SecurityNotFoundException(Integer securityId) {
        super("Fund manager with employee id " + securityId + " not found.");
        this.securityId = securityId;
    }

}
