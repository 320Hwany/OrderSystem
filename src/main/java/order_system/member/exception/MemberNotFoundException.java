package order_system.member.exception;

import order_system.global.exception.NotFoundException;

import static order_system.global.constant.ExceptionMessageConstant.*;

public class MemberNotFoundException extends NotFoundException {

    private static final String MESSAGE = MEMBER_NOTFOUND_EXCEPTION.message;

    public MemberNotFoundException() {
        super(MESSAGE);
    }
}
