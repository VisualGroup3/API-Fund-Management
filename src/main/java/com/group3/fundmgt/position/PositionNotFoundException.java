package com.group3.fundmgt.position;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PositionNotFoundException extends IllegalArgumentException {
    long positionID;
    public PositionNotFoundException(Long positionID) {
        super("Position with position id " + positionID + " not found.");
        this.positionID = positionID;
    }
}
