package br.com.pagamentos.gateway.converter;

import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.gateway.BoletoObjectGateway;
import br.com.pagamentos.gateway.ClienteGateway;
import br.com.pagamentos.gateway.GerarBoletoGateway;
import org.springframework.core.convert.converter.Converter;

public class GerarBoletoToBoletoGateway implements Converter<GerarBoleto, GerarBoletoGateway> {

    @Override
    public GerarBoletoGateway convert(GerarBoleto source) {
//        ClienteGateway cliente = new ClienteGateway(
//                source.getCliente().getNome(),
//                source.getCliente().getSobrenome(),
//                source.getCliente().getCpf());

        ClienteGateway cliente = new ClienteGateway(source.getCliente().getCpf());

        BoletoObjectGateway pagamento = new BoletoObjectGateway(
                "1234567894561234567894563123",
                source.getEmissaoBoleto().getDataEmissao(),
                source.getEmissaoBoleto().getDataVencimento(),
                source.getEmissaoBoleto().getValor());

        return GerarBoletoGateway.builder()
                .boletoObjectGateway(pagamento)
                .clienteGateway(cliente)
                .build();
    }
}
