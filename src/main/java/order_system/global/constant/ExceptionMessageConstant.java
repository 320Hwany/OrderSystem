package order_system.global.constant;

public enum ExceptionMessageConstant {

    SESSION_UNAUTHORIZED_EXCEPTION("세션이 존재하지 않습니다"),
    MEMBER_NOT_MATCH_EXCEPTION("회원정보가 일치하지 않습니다"),
    MEMBER_UNAUTHORIZED_EXCEPTION("회원 로그인 후 이용해주세요"),
    MEMBER_NOT_FOUND_EXCEPTION("회원을 찾을 수 없습니다"),
    ITEM_NOT_FOUND_EXCEPTION("상품을 찾을 수 없습니다");

    public final String message;

    ExceptionMessageConstant(final String message) {
        this.message = message;
    }
}
