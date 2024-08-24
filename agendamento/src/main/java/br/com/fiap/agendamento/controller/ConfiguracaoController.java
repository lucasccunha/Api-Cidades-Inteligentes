package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.model.Configuracao;
import br.com.fiap.agendamento.service.ConfiguracaoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuracoes")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Configuracao criarConfiguracao(@RequestBody Configuracao configuracao) {
        return configuracaoService.criarConfiguracao(configuracao);
    }

    @GetMapping
    public List<Configuracao> listarConfiguracoes() {
        return configuracaoService.listarConfiguracoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Configuracao> buscarPorId(@PathVariable ObjectId id) {
        return configuracaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Configuracao> atualizarConfiguracao(@PathVariable ObjectId id, @RequestBody Configuracao configuracao) {
        return ResponseEntity.ok(configuracaoService.atualizarConfiguracao(id, configuracao));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConfiguracao(@PathVariable ObjectId id) {
        configuracaoService.deletarConfiguracao(id);
    }
}

