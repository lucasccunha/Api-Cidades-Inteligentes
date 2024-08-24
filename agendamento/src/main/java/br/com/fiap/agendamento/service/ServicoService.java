package br.com.fiap.agendamento.service;


import br.com.fiap.agendamento.model.Servico;
import br.com.fiap.agendamento.repository.ServicoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico criarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(ObjectId id) {
        return servicoRepository.findById(id);
    }

    public Servico atualizarServico(ObjectId id, Servico servico) {
        servico.setId(id);
        return servicoRepository.save(servico);
    }

    public void deletarServico(ObjectId id) {
        servicoRepository.deleteById(id);
    }
}

