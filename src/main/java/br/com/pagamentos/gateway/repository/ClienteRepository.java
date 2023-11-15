package br.com.pagamentos.gateway.repository;


import br.com.pagamentos.gateway.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    boolean existsByDocumento(String cpf);

    boolean existsByEmail(String email);

}