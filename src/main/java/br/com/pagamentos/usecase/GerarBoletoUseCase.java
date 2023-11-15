package br.com.pagamentos.usecase;

import br.com.pagamentos.config.exceptions.CpfNaoEncontradoException;
import br.com.pagamentos.entity.Boleto;
import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.gateway.BoletoGateway;
import br.com.pagamentos.gateway.ValidarClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GerarBoletoUseCase {

    private final BoletoGateway boletoGateway;
    private final ValidarClienteGateway validarClienteGateway;

    public Boleto executar(GerarBoleto gerarBoleto) {

        var cliente = gerarBoleto.getCliente();

        if (validarClienteGateway.validarCpfExistente(cliente.getCpf())){

            return boletoGateway.emitir(gerarBoleto);
        }

        throw new CpfNaoEncontradoException(HttpStatus.NOT_FOUND, "CPF Não encontrado!", "CPF Não encontrado na base de dados");
    }
}