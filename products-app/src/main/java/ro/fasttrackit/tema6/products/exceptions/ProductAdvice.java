package ro.fasttrackit.tema6.products.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ProductAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleResourceNotFoundExceptions(ResourceNotFoundException ex) {
        return new ApiError(ex.getMessage());
    }

}

@Value
class ApiError {
    String message;
}

