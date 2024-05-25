package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.model.Agendamento;
import br.com.fiap.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento gravar(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarPorId(Long id){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()){
            return agendamentoOptional.get();
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public List<Agendamento> listarTodosContatos(){
        return agendamentoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()){
            agendamentoRepository.delete(agendamentoOptional.get());
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

//    public List<Agendamento> mostrarColetasDoMes(LocalDate dataInicial, LocalDate dataFinal){
//        return agendamentoRepository.findByDataColeta(dataInicial, dataFinal);
//    }

    public Agendamento atualizar(Agendamento agendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamento.getId());
        if (agendamentoOptional.isPresent()){
            return agendamentoRepository.save(agendamento);
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public Agendamento buscarPeloNomeCliente(String nome){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByNomeCliente(nome);
        if (agendamentoOptional.isPresent()){
            return agendamentoOptional.get();
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }
}
