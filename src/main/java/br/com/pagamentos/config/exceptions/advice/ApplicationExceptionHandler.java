package br.com.pagamentos.config.exceptions.advice;

import br.com.pagamentos.config.exceptions.CpfNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CpfNaoEncontradoException.class)
    public ResponseEntity<PadraoException> handleCpfNaoEncontradoException(CpfNaoEncontradoException cpfNaoEncontradoException) {
        PadraoException padraoException = new PadraoException(HttpStatus.NOT_FOUND,
        "Cliente não encontrado.",
        "Informe um CPF válido.");
        return new ResponseEntity<>(padraoException, padraoException.getStatus());
    }

}