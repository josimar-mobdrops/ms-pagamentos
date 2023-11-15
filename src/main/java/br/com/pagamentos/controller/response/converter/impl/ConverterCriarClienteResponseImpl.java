package br.com.pagamentos.controller.response.converter.impl;

import br.com.pagamentos.controller.response.BoletoResponse;
import br.com.pagamentos.controller.response.converter.IConverterCriarClienteResponse;
import br.com.pagamentos.entity.Boleto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConverterCriarClienteResponseImpl implements IConverterCriarClienteResponse {

    @Override
    public BoletoResponse entityToResponse(Boleto boleto) {

        return BoletoResponse.builder()
                .codigoBarra(boleto.getCodigoBarra())
                .build();
    }
}
