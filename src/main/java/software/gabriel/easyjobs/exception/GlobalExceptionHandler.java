/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import software.gabriel.easyjobs.exception.base.ErrorSchema;
import software.gabriel.easyjobs.exception.curriculo.ResumoJaCadastradoException;
import software.gabriel.easyjobs.exception.curriculo.ResumoNaoCadastradoException;
import software.gabriel.easyjobs.exception.global.EntidadeOutroUsuarioException;
import software.gabriel.easyjobs.exception.global.IdNaoLocalizadoException;
import software.gabriel.easyjobs.exception.mail.ErroEnvioEmailException;
import software.gabriel.easyjobs.exception.security.AtivacaoInexistenteException;
import software.gabriel.easyjobs.exception.security.CodigoAtivacaoExpiradoException;
import software.gabriel.easyjobs.exception.security.CodigoAtivacaoIncorretoException;
import software.gabriel.easyjobs.exception.security.ContaJaAtivadaException;
import software.gabriel.easyjobs.exception.security.ContaNaoAtivadaException;
import software.gabriel.easyjobs.exception.security.EmailJaCadastradoException;
import software.gabriel.easyjobs.exception.security.EmailNaoCadastradoException;
import software.gabriel.easyjobs.exception.security.RenovacaoAntecipadaCodigoAtivacaoException;
import software.gabriel.easyjobs.exception.security.SenhaIncorretaException;
import software.gabriel.easyjobs.exception.security.UsuarioJaVinculadoException;

/**
 *
 * @author gabriel
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorSchema> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String mensagem = e.getFieldError().getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorSchema> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        if (e.getCause() instanceof InvalidFormatException ex && !ex.getPath().isEmpty()) {
            String campo = ex.getPath().stream().filter(item -> item.getFieldName() != null).findFirst().get().getFieldName();
            String mensagem = campo != null ? String.format("O campo '%s' possui um valor inválido!", campo) : "Foi enviado um valor inválido!";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorSchema> constraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String mensagem = violations.isEmpty() ? "Uma constraint foi violada!" : violations.iterator().next().getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(IdNaoLocalizadoException.class)
    public ResponseEntity<ErrorSchema> idNaoLocalizadoException(IdNaoLocalizadoException e, HttpServletRequest request) {
        String mensagem = e.getMensagem();
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EntidadeOutroUsuarioException.class)
    public ResponseEntity<ErrorSchema> entidadeOutroUsuárioException(EntidadeOutroUsuarioException e, HttpServletRequest request) {
        String mensagem = e.getMensagem();
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErrorSchema> emailJaCadastradoException(EmailJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailNaoCadastradoException.class)
    public ResponseEntity<ErrorSchema> emailNaoCadastradoException(EmailNaoCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ContaJaAtivadaException.class)
    public ResponseEntity<ErrorSchema> contaJaAtivadaException(ContaJaAtivadaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CodigoAtivacaoIncorretoException.class)
    public ResponseEntity<ErrorSchema> codigoAtivacaoIncorretoException(CodigoAtivacaoIncorretoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CodigoAtivacaoExpiradoException.class)
    public ResponseEntity<ErrorSchema> codigoAtivacaoExpiradoException(CodigoAtivacaoExpiradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AtivacaoInexistenteException.class)
    public ResponseEntity<ErrorSchema> ativacaoInexistenteException(AtivacaoInexistenteException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(RenovacaoAntecipadaCodigoAtivacaoException.class)
    public ResponseEntity<ErrorSchema> renovacaoAntecipadaCodigoAtivacaoException(RenovacaoAntecipadaCodigoAtivacaoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ErroEnvioEmailException.class)
    public ResponseEntity<ErrorSchema> erroEnvioEmailException(ErroEnvioEmailException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(SenhaIncorretaException.class)
    public ResponseEntity<ErrorSchema> senhaIncorretaException(SenhaIncorretaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ContaNaoAtivadaException.class)
    public ResponseEntity<ErrorSchema> contaNaoAtivadaException(ContaNaoAtivadaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UsuarioJaVinculadoException.class)
    public ResponseEntity<ErrorSchema> usuarioJaVinculadoException(UsuarioJaVinculadoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResumoNaoCadastradoException.class)
    public ResponseEntity<ErrorSchema> resumoNaoCadastradoException(ResumoNaoCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResumoJaCadastradoException.class)
    public ResponseEntity<ErrorSchema> resumoJaCadastradoException(ResumoJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorSchema err = new ErrorSchema(Instant.now(), status.value(), mensagem, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
