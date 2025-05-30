package com.jaimebarrera.demojpa.infrastructure.error.model;

public class FieldError {

    private String field;
    private String error;

    public FieldError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}
