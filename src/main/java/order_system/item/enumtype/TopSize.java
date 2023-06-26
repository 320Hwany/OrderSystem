package order_system.item.enumtype;


public enum TopSize {

    S("small"),
    M("medium"),
    L("large"),
    XL("X large");

    public final String value;

    TopSize(final String value) {
        this.value = value;
    }
}
