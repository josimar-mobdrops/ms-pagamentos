package br.com.pagamentos.gateway;

import br.com.pagamentos.entity.Boleto;
import br.com.pagamentos.entity.GerarBoleto;

public interface BoletoGateway {

    Boleto emitir(GerarBoleto clienteEntity);

}
