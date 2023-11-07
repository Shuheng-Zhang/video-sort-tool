package top.shuzz.video.sort.service.core.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.shuzz.video.sort.service.core.response.FailureResponse;
import top.shuzz.video.sort.service.core.response.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessExceptionHandler(final BusinessException exception) {
        return ResponseResult.fail(exception.getFailureResponse(), exception.getErrInfo());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult requestParamInvalidExceptionHandler(final MethodArgumentNotValidException exception) {

        final var errors = exception.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

        return ResponseResult.fail(FailureResponse.BAD_REQUEST, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseResult resourceInvalidExceptionHandler(final IllegalArgumentException exception) {
        return ResponseResult.fail(FailureResponse.BAD_REQUEST, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(final Exception exception) {
        return ResponseResult.fail(FailureResponse.SYS_ERROR, exception.getMessage());
    }
}
