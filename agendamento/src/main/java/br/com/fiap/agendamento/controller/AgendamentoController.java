package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.dto.AgendamentoCadastroDto;
import br.com.fiap.agendamento.dto.AgendamentoExibicaoDto;
import br.com.fiap.agendamento.model.Agendamento;
import br.com.fiap.agendamento.service.AgendamentoService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoExibicaoDto gravar(@RequestBody @Valid AgendamentoCadastroDto agendamentoCadastroDto) {
        return agendamentoService.gravar(agendamentoCadastroDto);
    }

    @GetMapping("/agendamento/todos")
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoExibicaoDto> listarTodosAgendamentos(Pageable paginacao) {
        return agendamentoService.listarTodosAgendamentos(paginacao);
    }

    @DeleteMapping("/agendamento/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable ObjectId id) {
        agendamentoService.excluir(id);
    }

    @PutMapping("/agendamento/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento atualizar(@RequestBody Agendamento agendamento) {
        return agendamentoService.atualizar(agendamento);
    }

    @GetMapping("/agendamento/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibicaoDto buscarAgendamentoPeloNomeCliente(@PathVariable String nome) {
        return agendamentoService.buscarPeloNomeCliente(nome);
    }

    @GetMapping("/agendamento/buscar/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibicaoDto buscarPeloId(@PathVariable ObjectId id) {
        return agendamentoService.buscarPeloId(id);
    }

    //api/agendamento?nome=Fulano
    @GetMapping(value = "/agendamento", params = "nome")
    public AgendamentoExibicaoDto buscarAgendamentoPorNome(@RequestParam String nome) {
        return agendamentoService.buscarPeloNomeCliente(nome);
    }

    //api/agendamentos?dataInicio=2001-06-07&dataFinal=2024-05-26
    @GetMapping(value = "/agendamento", params = {"dataInicio", "dataFinal"})
    public List<AgendamentoExibicaoDto> listarAgendamentos(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFinal
    ) {
        return agendamentoService.listarAgendamentosDoPeriodo(dataInicio, dataFinal);
    }


}
