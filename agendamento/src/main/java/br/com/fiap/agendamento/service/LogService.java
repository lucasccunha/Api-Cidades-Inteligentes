package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.model.Log;
import br.com.fiap.agendamento.repository.LogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log criarLog(Log log) {
        return logRepository.save(log);
    }

    public List<Log> listarLogs() {
        return logRepository.findAll();
    }

    public void deletarLog(ObjectId id) {
        logRepository.deleteById(id);
    }
}

