package com.epam.demojenkinsspringboot.exception;

import lombok.Getter;
@Getter
public class DataNotFoundException extends RuntimeException {
    private final String dataName;
    private final String fieldName;
    private final Long fieldValue;

    public DataNotFoundException(String dataName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %d", dataName, fieldName, fieldValue));
        this.dataName = dataName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
