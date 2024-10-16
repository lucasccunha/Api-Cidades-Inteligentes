package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.dto.AgendamentoCadastroDto;
import br.com.fiap.agendamento.dto.AgendamentoExibicaoDto;
import br.com.fiap.agendamento.model.Agendamento;
import br.com.fiap.agendamento.repository.AgendamentoRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgendamentoServiceTest {

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Mock
    private AgendamentoRepository agendamentoRepository;


    private AgendamentoCadastroDto dto;

    @Captor
    private ArgumentCaptor<Agendamento> agendamentoCaptor;

    @Test
    void deveriaSalvarAgendamento() {
        // ARRANGE
        Agendamento agendamentoSalvoMock = new Agendamento();
        agendamentoSalvoMock.setId(new ObjectId());
        agendamentoSalvoMock.setNomeCliente("Fulano");
        agendamentoSalvoMock.setDataAgendamento(LocalDate.parse("2024-08-24"));
        agendamentoSalvoMock.setTipoMaterial("Plastico");
        agendamentoSalvoMock.setDescricao("Reciclavel");

        when(agendamentoRepository.save(any(Agendamento.class))).thenReturn(agendamentoSalvoMock);

        this.dto = new AgendamentoCadastroDto(new ObjectId(), "Fulano", LocalDate.parse("2024-08-24"), "Plastico", "Reciclavel");

        // ACT
        AgendamentoExibicaoDto resultado = agendamentoService.gravar(dto);

        // ASSERT
        then(agendamentoRepository).should().save(agendamentoCaptor.capture());
        Agendamento agendamentoGravado = agendamentoCaptor.getValue();
        Assertions.assertEquals("Fulano", agendamentoGravado.getNomeCliente());
        Assertions.assertNotNull(resultado.id());
    }

}