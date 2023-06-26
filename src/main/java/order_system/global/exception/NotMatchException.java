package order_system.global.exception;

import lombok.Getter;

@Getter
public abstract class NotMatchException extends RuntimeException {

    private final String message;

    public NotMatchException(String message) {
        this.message = message;
    }
}
