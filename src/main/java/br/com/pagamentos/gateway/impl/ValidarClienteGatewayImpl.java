package br.com.pagamentos.gateway.impl;

import br.com.pagamentos.gateway.ValidarClienteGateway;
import br.com.pagamentos.gateway.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidarClienteGatewayImpl implements ValidarClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public boolean validarCpfExistente(String cpf) {
        return clienteRepository.existsByDocumento(cpf);
    }
}
