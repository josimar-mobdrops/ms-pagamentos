package br.com.pagamentos.controller;

import br.com.pagamentos.config.exceptions.CpfNaoEncontradoException;
import br.com.pagamentos.controller.request.BoletoRequest;
import br.com.pagamentos.controller.request.ClienteRequest;
import br.com.pagamentos.controller.request.GerarBoletoRequest;
import br.com.pagamentos.controller.request.converter.GerarBoletoRequetToEntity;
import br.com.pagamentos.controller.response.BoletoResponse;
import br.com.pagamentos.controller.response.converter.IConverterCriarClienteResponse;
import br.com.pagamentos.entity.Boleto;
import br.com.pagamentos.entity.Cliente;
import br.com.pagamentos.entity.EmissaoBoleto;
import br.com.pagamentos.entity.GerarBoleto;
import br.com.pagamentos.usecase.GerarBoletoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.fail;

@ExtendWith(MockitoExtension.class)
public class BoletoControllerTest {

    @Mock
    private GerarBoletoUseCase gerarBoletoUseCase;

    @Mock
    private GerarBoletoRequetToEntity gerarBoletoRequetToEntity;

    @Mock
    private IConverterCriarClienteResponse iConverterCriarClienteResponse;

    @Mock
    private GerarBoletoRequest gerarBoletoRequest;

    @Mock
    private GerarBoleto gerarBoleto;

    @Mock
    private EmissaoBoleto emissaoBoleto;

    @Mock
    private BoletoResponse boletoResponse;

    @Mock
    private ClienteRequest clienteRequest;

    @Mock
    private BoletoRequest boletoRequest;

    @Mock
    private Boleto boleto;

    @Mock
    private Cliente cliente;

    @InjectMocks
    private PagamentosController pagamentosController;

    @BeforeEach
    void setup() {
        BigDecimal valor = new BigDecimal(159.30);
        LocalDate dataVencimento = LocalDate.now().plusDays(3);
        LocalDate dataEmissao = LocalDate.now();

        clienteRequest = new ClienteRequest("19100000000");
        boletoRequest = new BoletoRequest(dataVencimento, dataEmissao,valor);

        gerarBoletoRequest = new GerarBoletoRequest(clienteRequest, boletoRequest);

        cliente = new Cliente("19100000000");
        emissaoBoleto = new EmissaoBoleto(LocalDate.now().plusDays(3), LocalDate.now(), valor);
        gerarBoleto = new GerarBoleto(cliente,emissaoBoleto);

        boleto = new Boleto("15123123123123123", dataVencimento, dataEmissao, valor);
        boletoResponse = new BoletoResponse("15123123123123123");
    }

    @Test
    void testEmitirBoletoSucesso() {

        when(gerarBoletoRequetToEntity.convert(gerarBoletoRequest)).thenReturn(gerarBoleto);
        when(gerarBoletoUseCase.executar(gerarBoleto)).thenReturn(boleto);
        when(iConverterCriarClienteResponse.entityToResponse(boleto)).thenReturn(boletoResponse);

        ResponseEntity<BoletoResponse> responseEntity = pagamentosController.emitirBoleto(gerarBoletoRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(boletoResponse, responseEntity.getBody());
        assertEquals(boletoResponse.getCodigoBarra(), responseEntity.getBody().getCodigoBarra());

        verify(gerarBoletoRequetToEntity, times(1)).convert(gerarBoletoRequest);
        verify(gerarBoletoUseCase, times(1)).executar(gerarBoleto);
        verify(iConverterCriarClienteResponse, times(1)).entityToResponse(boleto);
    }

    @Test
    void testEmitirBoleto_CpfNaoEncontradoException() {

        when(gerarBoletoRequetToEntity.convert(gerarBoletoRequest)).thenReturn(new GerarBoleto());
        when(gerarBoletoUseCase.executar(any())).thenThrow(new CpfNaoEncontradoException(HttpStatus.NOT_FOUND, "Cliente não encontrado.", "Informe um CPF válido."));

        try {
            pagamentosController.emitirBoleto(gerarBoletoRequest);
            fail("Deveria ter lançado CpfNaoEncontradoException");
        } catch (CpfNaoEncontradoException e) {
            assertEquals("Cliente não encontrado.", e.getMessage());
        }

        // Verifica se os métodos dos mocks foram chamados corretamente
        verify(gerarBoletoRequetToEntity, times(1)).convert(gerarBoletoRequest);
        verify(gerarBoletoUseCase, times(1)).executar(any());
        verify(iConverterCriarClienteResponse, never()).entityToResponse(any());
    }
}
