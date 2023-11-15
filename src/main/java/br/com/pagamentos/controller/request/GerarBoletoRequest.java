package br.com.pagamentos.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GerarBoletoRequest {

    private ClienteRequest clienteRequest;
    private BoletoRequest boletoRequest;

}
