package br.com.sistemaponto.exception;

import br.com.sistemaponto.exception.intercept.ApplicationException;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
