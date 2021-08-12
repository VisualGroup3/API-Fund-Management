package com.group3.fundmgt.fund;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FundNotFoundException extends IllegalArgumentException {
    private final Long fundId;

    public FundNotFoundException(Long fundId) {
        super("Fund manager with employee id " + fundId + " not found.");
        this.fundId = fundId;
    }
}
