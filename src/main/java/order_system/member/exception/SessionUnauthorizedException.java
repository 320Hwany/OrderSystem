package order_system.member.exception;

import order_system.global.exception.UnauthorizedException;

import static order_system.global.constant.ExceptionMessageConstant.*;

public class SessionUnauthorizedException extends UnauthorizedException {

    private static final String MESSAGE = SESSION_UNAUTHORIZED_EXCEPTION.message;

    public SessionUnauthorizedException() {
        super(MESSAGE);
    }
}
