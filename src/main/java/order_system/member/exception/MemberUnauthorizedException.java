package order_system.member.exception;

import order_system.global.exception.UnauthorizedException;

import static order_system.global.constant.ExceptionMessageConstant.MEMBER_UNAUTHORIZED_EXCEPTION;


public class MemberUnauthorizedException extends UnauthorizedException {

    private static final String MESSAGE = MEMBER_UNAUTHORIZED_EXCEPTION.message;


    public MemberUnauthorizedException() {
        super(MESSAGE);
    }
}
