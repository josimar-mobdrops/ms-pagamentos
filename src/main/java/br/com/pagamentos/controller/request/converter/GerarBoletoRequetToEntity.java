package br.com.pagamentos.controller.request.converter;

import br.com.pagamentos.entity.Cliente;
import br.com.pagamentos.entity.EmissaoBoleto;
import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.controller.request.GerarBoletoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GerarBoletoRequetToEntity implements Converter<GerarBoletoRequest, GerarBoleto> {
    @Override
    public GerarBoleto convert(GerarBoletoRequest source) {

//        Cliente cliente = new Cliente(source.getClienteRequest().getNome(),
//                source.getClienteRequest().getSobrenome(),
//                source.getClienteRequest().getCpf());
//
        Cliente cliente = new Cliente(source.getClienteRequest().getCpf());

        EmissaoBoleto emissaoBoleto = new EmissaoBoleto(source.getBoletoRequest().getDataEmissao(),
                source.getBoletoRequest().getDataVencimento(),
                source.getBoletoRequest().getValor());

        return GerarBoleto.builder()
                .emissaoBoleto(emissaoBoleto)
                .cliente(cliente)
                .build();
    }
}
