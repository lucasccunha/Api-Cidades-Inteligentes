package br.com.fiap.agendamento.dto;

import br.com.fiap.agendamento.model.Agendamento;

import java.time.LocalDate;

public record AgendamentoExibicaoDto (
        Long id,
        String nomeCliente,
        LocalDate dataAgendamento,
        String tipoMaterial,
        String descricao
){

    public AgendamentoExibicaoDto(Agendamento agendamento){
        this(agendamento.getId(),
                agendamento.getNomeCliente(),
                agendamento.getDataAgendamento(),
                agendamento.getTipoMaterial(),
                agendamento.getDescricao()
        );
    }

}
