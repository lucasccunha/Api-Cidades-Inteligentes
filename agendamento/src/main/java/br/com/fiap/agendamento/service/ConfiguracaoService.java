package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.model.Configuracao;
import br.com.fiap.agendamento.repository.ConfiguracaoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public Configuracao criarConfiguracao(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }

    public List<Configuracao> listarConfiguracoes() {
        return configuracaoRepository.findAll();
    }

    public Optional<Configuracao> buscarPorId(ObjectId id) {
        return configuracaoRepository.findById(id);
    }

    public Configuracao atualizarConfiguracao(ObjectId id, Configuracao configuracao) {
        configuracao.setId(id);
        return configuracaoRepository.save(configuracao);
    }

    public void deletarConfiguracao(ObjectId id) {
        configuracaoRepository.deleteById(id);
    }
}
