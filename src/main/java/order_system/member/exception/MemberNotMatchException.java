package order_system.member.exception;

import order_system.global.exception.NotMatchException;

import static order_system.global.constant.ExceptionMessageConstant.MEMBER_NOT_FOUND_EXCEPTION;

public class MemberNotMatchException extends NotMatchException {

    private static final String MESSAGE = MEMBER_NOT_FOUND_EXCEPTION.message;

    public MemberNotMatchException() {
        super(MESSAGE);
    }
}
