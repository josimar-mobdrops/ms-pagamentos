package br.com.pagamentos.controller.response.converter;

import br.com.pagamentos.controller.response.BoletoResponse;
import br.com.pagamentos.entity.Boleto;

public interface IConverterCriarClienteResponse {

    BoletoResponse entityToResponse(Boleto clienteEntity);
}
