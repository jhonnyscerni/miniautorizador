package br.com.vr.miniautorizador.domain.exceptions;

public class EntityInUseException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityInUseException(String message) {
        super(message);
    }

    public EntityInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
