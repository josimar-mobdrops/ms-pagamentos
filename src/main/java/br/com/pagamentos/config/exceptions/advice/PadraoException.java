package br.com.pagamentos.config.exceptions.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class PadraoException {

    private HttpStatus status;
    private String message;
    private String developerMessage;
}