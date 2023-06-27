package order_system.item.exception;

import order_system.global.constant.ExceptionMessageConstant;
import order_system.global.exception.NotFoundException;

import static order_system.global.constant.ExceptionMessageConstant.ITEM_NOT_FOUND_EXCEPTION;

public class ItemNotFoundException extends NotFoundException {

    private static final String MESSAGE = ITEM_NOT_FOUND_EXCEPTION.message;
    public ItemNotFoundException() {
        super(MESSAGE);
    }
}
