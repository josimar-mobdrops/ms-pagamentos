package br.com.pagamentos.gateway;

public interface ValidarClienteGateway {

    boolean validarCpfExistente(String cpf);
}
