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
import software.gabriel.easyjobs.exception.ativacao.CodigoAtivacaoExpiradoException;
import software.gabriel.easyjobs.exception.ativacao.CodigoAtivacaoIncorretoException;
import software.gabriel.easyjobs.exception.mail.ErroEnvioEmailException;
import software.gabriel.easyjobs.exception.usuario.ContaJaAtivadaException;
import software.gabriel.easyjobs.exception.usuario.EmailJaCadastradoException;
import software.gabriel.easyjobs.exception.usuario.EmailNaoCadastradoException;

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

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<BaseError> emailJaCadastradoException(EmailJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailNaoCadastradoException.class)
    public ResponseEntity<BaseError> emailNaoCadastradoException(EmailNaoCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ContaJaAtivadaException.class)
    public ResponseEntity<BaseError> contaJaAtivadaException(ContaJaAtivadaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CodigoAtivacaoIncorretoException.class)
    public ResponseEntity<BaseError> codigoAtivacaoIncorretoException(CodigoAtivacaoIncorretoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CodigoAtivacaoExpiradoException.class)
    public ResponseEntity<BaseError> codigoAtivacaoExpiradoException(CodigoAtivacaoExpiradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ErroEnvioEmailException.class)
    public ResponseEntity<BaseError> erroEnvioEmailException(ErroEnvioEmailException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
