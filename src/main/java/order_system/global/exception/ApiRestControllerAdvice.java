package order_system.global.exception;

import order_system.member.exception.MemberNotMatchException;
import order_system.member.exception.SessionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static order_system.global.constant.StatusCodeConstant.*;

@RestControllerAdvice
public class ApiRestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponseDto handleException(MethodArgumentNotValidException e) {
        return ErrorResponseDto.builder()
                .statusCode(BAD_REQUEST.value)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MemberNotMatchException.class)
    ErrorResponseDto handleException(MemberNotMatchException e) {
        return ErrorResponseDto.builder()
                .statusCode(BAD_REQUEST.value)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SessionNotFoundException.class)
    ErrorResponseDto handleException(SessionNotFoundException e) {
        return ErrorResponseDto.builder()
                .statusCode(NOT_FOUND.value)
                .message(e.getMessage())
                .build();
    }
}
