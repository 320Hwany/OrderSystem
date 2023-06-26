package order_system.global.exception;

import lombok.Getter;


@Getter
public class UnauthorizedException extends RuntimeException {


    private final String message;

    public UnauthorizedException(final String message) {
        this.message = message;
    }
}
