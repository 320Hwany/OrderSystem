package order_system.order;

import lombok.Getter;

@Getter
public enum OrderStatus {

    IN_BASKET("장바구니"),

    COMPLETE("결제 완료"),

    REFUND("환불 완료");

    private final String value;

    OrderStatus(final String value) {
        this.value = value;
    }
}
