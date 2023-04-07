/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author gabriel
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String mensagem = e.getFieldError().getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
