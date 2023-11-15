package br.com.pagamentos.gateway;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class GerarBoletoGateway {

    private ClienteGateway clienteGateway;
    private BoletoObjectGateway boletoObjectGateway;
}
