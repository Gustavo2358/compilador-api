package br.edu.ufabc.api.response;

import java.util.Collections;
import java.util.List;

public class ApiResponse<T> {
    private final Boolean success;
    private final String message;
    private final T data;
    private final List<String> errors;

    public ApiResponse(Boolean success, String message, T data, List<String> errors) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}