package order_system.delivery.exception;

import order_system.global.exception.NotFoundException;

import static order_system.global.constant.ExceptionMessageConstant.*;

public class DeliveryNotFoundException extends NotFoundException {

    private static final String MESSAGE = DELIVERY_NOT_FOUND_EXCEPTION.message;

    public DeliveryNotFoundException() {
        super(MESSAGE);
    }
}
