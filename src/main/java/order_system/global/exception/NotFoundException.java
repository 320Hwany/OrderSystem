package order_system.global.exception;

import lombok.Getter;

import static order_system.global.constant.StatusCodeConstant.*;

@Getter
public abstract class NotFoundException extends RuntimeException {

    private final String statusCode = NOT_FOUND.value;
    private final String message;

    public NotFoundException(final String message) {
        this.message = message;
    }
}
