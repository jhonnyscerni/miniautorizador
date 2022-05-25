package br.com.vr.miniautorizador.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnprocessableEntity(String message) {
        super(message);
    }

    public UnprocessableEntity(String message, Throwable cause) {
        super(message, cause);
    }
}

