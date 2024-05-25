package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.model.Agendamento;
import br.com.fiap.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento gravar(@RequestBody Agendamento agendamento){
        return agendamentoService.gravar(agendamento);
    }

    @GetMapping("/agendamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> listarTodosAgendamentos(){
        return agendamentoService.listarTodosContatos();
    }

    @DeleteMapping("/agendamento/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        agendamentoService.excluir(id);
    }

    @PutMapping("/agendamento")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento atualizar(Agendamento agendamento){
        return agendamentoService.atualizar(agendamento);
    }

    @GetMapping("/agendamento/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento buscarAgendamentoPeloNomeCliente(String nome){
        return agendamentoService.buscarPeloNomeCliente(nome);
    }
}
