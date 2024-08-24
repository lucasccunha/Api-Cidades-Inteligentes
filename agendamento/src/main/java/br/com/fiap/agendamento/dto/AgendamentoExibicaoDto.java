package br.com.fiap.agendamento.dto;

import br.com.fiap.agendamento.model.Agendamento;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public record AgendamentoExibicaoDto (
        ObjectId id,
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
