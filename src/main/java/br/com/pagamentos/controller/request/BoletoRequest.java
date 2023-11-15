package br.com.pagamentos.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoRequest {

    private LocalDate dataVencimento;
    private LocalDate dataEmissao;
    private BigDecimal valor;
}
