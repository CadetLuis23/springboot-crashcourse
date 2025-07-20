package com.example.demo.myfirstapi.exception;

import java.util.List;

public class ErrorResponse {
    private String message;
    private List<FieldError> errors;

    public ErrorResponse(String message, List<FieldError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public static class FieldError {
        private String field;
        private String error;

        public FieldError(String field, String error) {
            this.field = field;
            this.error = error;
        }
    }
}
