package order_system.order.exception;

import order_system.global.constant.ExceptionMessageConstant;
import order_system.global.exception.NotFoundException;

import static order_system.global.constant.ExceptionMessageConstant.*;

public class OrderNotFoundException extends NotFoundException {

    private static final String MESSAGE = ORDER_NOT_FOUND_EXCEPTION.message;
    public OrderNotFoundException() {
        super(MESSAGE);
    }
}
