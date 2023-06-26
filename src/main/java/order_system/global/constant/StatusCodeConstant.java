package order_system.global.constant;

public enum StatusCodeConstant {

    BAD_REQUEST("400"),
    UNAUTHORIZED("401"),
    FORBIDDEN("403"),
    NOT_FOUND("404");

    public final String value;

    StatusCodeConstant(final String value) {
        this.value = value;
    }
}
