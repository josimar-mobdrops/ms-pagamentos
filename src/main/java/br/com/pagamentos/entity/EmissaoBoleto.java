package br.com.pagamentos.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmissaoBoleto {

    private LocalDate dataVencimento;
    private LocalDate dataEmissao;
    private BigDecimal valor;
}
