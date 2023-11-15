package br.com.pagamentos.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GerarBoleto {

    private Cliente cliente;
    private EmissaoBoleto emissaoBoleto;

}
