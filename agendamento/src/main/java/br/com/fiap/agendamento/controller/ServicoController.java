package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.model.Servico;
import br.com.fiap.agendamento.service.ServicoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico criarServico(@RequestBody Servico servico) {
        return servicoService.criarServico(servico);
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoService.listarServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable ObjectId id) {
        return servicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable ObjectId id, @RequestBody Servico servico) {
        return ResponseEntity.ok(servicoService.atualizarServico(id, servico));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarServico(@PathVariable ObjectId id) {
        servicoService.deletarServico(id);
    }
}

