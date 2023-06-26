package order_system.global.exception;

import order_system.member.exception.MemberNotMatchException;
import order_system.member.exception.SessionUnauthorizedException;
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

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    ErrorResponseDto handleException(UnauthorizedException e) {
        return ErrorResponseDto.builder()
                .statusCode(UNAUTHORIZED.value)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SessionUnauthorizedException.class)
    ErrorResponseDto handleException(SessionUnauthorizedException e) {
        return ErrorResponseDto.builder()
                .statusCode(UNAUTHORIZED.value)
                .message(e.getMessage())
                .build();
    }
}
