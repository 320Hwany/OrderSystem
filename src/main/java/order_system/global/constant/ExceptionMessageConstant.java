package order_system.global.constant;

public enum ExceptionMessageConstant {

    SESSION_NOTFOUND_EXCEPTION("세션을 찾을 수 없습니다"),
    MEMBER_NOTFOUND_EXCEPTION("회원을 찾을 수 없습니다");

    public final String message;

    ExceptionMessageConstant(final String message) {
        this.message = message;
    }
}
