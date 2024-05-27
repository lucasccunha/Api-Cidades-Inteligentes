package br.com.fiap.agendamento.repository;

import br.com.fiap.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("SELECT c FROM Agendamento c WHERE c.nomeCliente = :nome")
    Optional<Agendamento> buscarAgendamentoPeloNome(@Param("nome")String nome);



    @Query("SELECT c FROM Agendamento c WHERE c.dataAgendamento BETWEEN :dataInicial AND :dataFinal")
    List<Agendamento> listarAgendamentosDoPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );
}
