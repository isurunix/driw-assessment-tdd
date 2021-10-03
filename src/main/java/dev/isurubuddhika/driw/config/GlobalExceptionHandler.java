package dev.isurubuddhika.driw.config;

import dev.isurubuddhika.driw.exception.ItemNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ItemNotFountException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ItemNotFountException exception) {
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }
}
