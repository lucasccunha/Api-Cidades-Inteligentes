package br.com.fiap.agendamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AgendamentoCadastroDto(
        Long id,

        @NotBlank(message = "Nome do Cliente é Obrigatório!")
        String nomeCliente,

        @NotNull(message = "Data do Agendamento é Obrigatório!")
        LocalDate dataAgendamento,

        @NotBlank(message = "Tipo de Material é Obrigatório!")
                @Size(min=1, max=10, message = "Campo não pode estar Vazio,No maximo 10 caracteres")
        String tipoMaterial,

        @NotBlank(message = "Descrição do Material é Obrigatório!")
                @Size(min=1, max=20, message = "Campo não pode estar Vazio,No maximo 20 caracteres")
        String descricao
) {
}
