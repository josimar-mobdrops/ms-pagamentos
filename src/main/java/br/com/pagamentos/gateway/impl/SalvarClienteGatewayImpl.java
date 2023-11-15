package br.com.pagamentos.gateway.impl;

import br.com.pagamentos.config.exceptions.BadGatewayException;
import br.com.pagamentos.entity.Boleto;
import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.gateway.BoletoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Log
public class SalvarClienteGatewayImpl implements BoletoGateway {


    @Override
    public Boleto emitir(GerarBoleto gerarBoleto) {

        try {

            log.info("realizando chamada externa.....");
            //TODO IMPLEMENTAR O WIREMOCK


        } catch (BadGatewayException e){
            throw new BadGatewayException(HttpStatus.BAD_GATEWAY, "Erro ao emitir boleto","Erro ao emitir boleto");
        }
        return Boleto.builder()
                .codigoBarra("152345613511512132545")
                .dataEmissao(LocalDate.now())
                .dataVencimento(LocalDate.now().plusDays(3))
                .build();
    }
}