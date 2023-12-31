package order_system.global.exception;

import lombok.Getter;


@Getter
public abstract class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(final String message) {
        this.message = message;
    }
}
