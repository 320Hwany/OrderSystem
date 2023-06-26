package order_system.global.exception;

import order_system.member.exception.SessionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiRestControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SessionNotFoundException.class)
    ErrorResponseDto handleException(SessionNotFoundException e) {
        return ErrorResponseDto.builder()
                .statusCode(e.getStatusCode())
                .message(e.getMessage())
                .build();
    }
}
