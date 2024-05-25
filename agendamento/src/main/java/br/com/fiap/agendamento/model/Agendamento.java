package br.com.fiap.agendamento.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "tbl_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "AGENDAMENTO_SEQ"
    )
    @SequenceGenerator(
            name = "AGENDAMENTO_SEQ",
            sequenceName = "AGENDAMENTO_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "tipo_material")
    private String tipoMaterial;

    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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


