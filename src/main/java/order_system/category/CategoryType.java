package order_system.category;

import lombok.Getter;

@Getter
public enum CategoryType {

    SHOES("신발"),
    TOP("상의"),
    BOTTOM("하의");

    private final String value;

    CategoryType(final String value) {
        this.value = value;
    }
}
