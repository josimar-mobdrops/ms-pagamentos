package br.com.pagamentos.controller;

import br.com.pagamentos.config.exceptions.BadGatewayException;
import br.com.pagamentos.config.exceptions.CpfNaoEncontradoException;
import br.com.pagamentos.controller.request.GerarBoletoRequest;
import br.com.pagamentos.controller.request.converter.GerarBoletoRequetToEntity;
import br.com.pagamentos.controller.response.BoletoResponse;
import br.com.pagamentos.controller.response.converter.IConverterCriarClienteResponse;
import br.com.pagamentos.entity.Boleto;
import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.usecase.GerarBoletoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boleto")
public class PagamentosController {

    private final GerarBoletoUseCase gerarBoletoUseCase;
    private final GerarBoletoRequetToEntity gerarBoletoRequetToEntity;
    private final IConverterCriarClienteResponse iConverterCriarClienteResponse;

    @PostMapping("emitir")
    public ResponseEntity<BoletoResponse> emitirBoleto(@RequestBody GerarBoletoRequest gerarBoletoRequest) {

        try {
            GerarBoleto gerarBoleto = gerarBoletoRequetToEntity.convert(gerarBoletoRequest);
            Boleto boleto = gerarBoletoUseCase.executar(gerarBoleto);
            BoletoResponse response = iConverterCriarClienteResponse.entityToResponse(boleto);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (CpfNaoEncontradoException exception) {
            throw new CpfNaoEncontradoException(
                    exception.getCode(),
                    exception.getMessage(),
                    exception.getDeveloperMessage());

        } catch (BadGatewayException exception){
            throw new BadGatewayException(
                    exception.getCode(),
                    exception.getMessage(),
                    exception.getDeveloperMessage());
        }
    }
}