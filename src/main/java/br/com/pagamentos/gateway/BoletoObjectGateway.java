package br.com.pagamentos.gateway;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoletoObjectGateway {

    private String codigoBarra;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private BigDecimal valor;
}
