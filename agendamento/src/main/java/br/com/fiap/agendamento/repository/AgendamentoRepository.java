package br.com.fiap.agendamento.repository;

import br.com.fiap.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Optional<Agendamento> findByNomeCliente(String name);
}
