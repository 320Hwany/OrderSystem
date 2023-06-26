package order_system.member.exception;

import order_system.global.exception.NotFoundException;

import static order_system.global.constant.ExceptionMessageConstant.*;

public class SessionNotFoundException extends NotFoundException {

    private static final String MESSAGE = SESSION_NOTFOUND_EXCEPTION.message;

    public SessionNotFoundException() {
        super(MESSAGE);
    }
}
