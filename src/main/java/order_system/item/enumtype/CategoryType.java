package order_system.item.enumtype;

public enum CategoryType {

    TOP("상의"),
    BOTTOM("하의"),
    SHOES("신발");

    public final String value;

    CategoryType(final String value) {
        this.value = value;
    }
}
