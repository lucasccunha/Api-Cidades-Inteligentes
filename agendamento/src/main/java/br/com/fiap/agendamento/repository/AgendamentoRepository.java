package br.com.fiap.agendamento.repository;

import br.com.fiap.agendamento.model.Agendamento;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends MongoRepository<Agendamento, ObjectId> {

    Optional<Agendamento> findByNomeCliente(String nome);

    List<Agendamento> findByDataAgendamentoBetween(LocalDate dataInicial, LocalDate dataFinal);
}

