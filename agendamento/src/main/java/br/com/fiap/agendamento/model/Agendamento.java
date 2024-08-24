package br.com.fiap.agendamento.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "tbl_agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    private ObjectId id;

    private String nomeCliente;

    private LocalDate dataAgendamento;

    private String tipoMaterial;

    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeCliente, that.nomeCliente) && Objects.equals(dataAgendamento, that.dataAgendamento) && Objects.equals(tipoMaterial, that.tipoMaterial) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCliente, dataAgendamento, tipoMaterial, descricao);
    }
}


