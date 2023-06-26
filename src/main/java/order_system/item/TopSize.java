package order_system.item;

import lombok.Getter;

@Getter
public enum TopSize {

    S("small"),
    M("medium"),
    L("large"),
    XL("X large");

    private final String value;

    TopSize(final String value) {
        this.value = value;
    }
}
