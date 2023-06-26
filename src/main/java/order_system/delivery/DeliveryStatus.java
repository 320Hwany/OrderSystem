package order_system.delivery;

import lombok.Getter;

@Getter
public enum DeliveryStatus {

    PROCESSED("출고 준비중"),
    SHIPPED("출고 완료"),
    DELIVERY("배송중"),
    COMPLETE("배송완료");

    private final String value;

    DeliveryStatus(final String value) {
        this.value = value;
    }
}
