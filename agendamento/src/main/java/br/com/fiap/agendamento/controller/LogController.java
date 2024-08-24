package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.model.Log;
import br.com.fiap.agendamento.service.LogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Log criarLog(@RequestBody Log log) {
        return logService.criarLog(log);
    }

    @GetMapping
    public List<Log> listarLogs() {
        return logService.listarLogs();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarLog(@PathVariable ObjectId id) {
        logService.deletarLog(id);
    }
}
