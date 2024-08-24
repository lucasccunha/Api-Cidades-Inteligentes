package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.dto.AgendamentoCadastroDto;
import br.com.fiap.agendamento.dto.AgendamentoExibicaoDto;
import br.com.fiap.agendamento.exception.AgendamentoNaoEncontradoException;
import br.com.fiap.agendamento.model.Agendamento;
import br.com.fiap.agendamento.repository.AgendamentoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoExibicaoDto gravar(AgendamentoCadastroDto agendamentoCadastroDto){
        Agendamento agendamento = new Agendamento();
        BeanUtils.copyProperties(agendamentoCadastroDto, agendamento);
        return new AgendamentoExibicaoDto(agendamentoRepository.save(agendamento));
    }

    public Agendamento buscarPorId(ObjectId id){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()){
            return agendamentoOptional.get();
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public Page<AgendamentoExibicaoDto> listarTodosAgendamentos(Pageable paginacao){
        return agendamentoRepository
                .findAll(paginacao)
                .map(AgendamentoExibicaoDto::new);
    }

    public void excluir(ObjectId id){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()){
            agendamentoRepository.delete(agendamentoOptional.get());
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public Agendamento atualizar(Agendamento agendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamento.getId());
        if (agendamentoOptional.isPresent()){
            return agendamentoRepository.save(agendamento);
        }else{
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public AgendamentoExibicaoDto buscarPeloNomeCliente(String nome){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByNomeCliente(nome);
        if (agendamentoOptional.isPresent()){
            return new AgendamentoExibicaoDto(agendamentoOptional.get());
        }else{
            throw new AgendamentoNaoEncontradoException("Agendamento não encontrado");
        }
    }

    public AgendamentoExibicaoDto buscarPeloId(ObjectId id){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()) {
            return new AgendamentoExibicaoDto(agendamentoOptional.get());
        } else{
            throw new AgendamentoNaoEncontradoException("Agendamento não Existe!");
        }
    }

    public List<AgendamentoExibicaoDto> listarAgendamentosDoPeriodo(LocalDate dataInicial, LocalDate dataFinal){
        return agendamentoRepository
                .findByDataAgendamentoBetween(dataInicial, dataFinal)
                .stream()
                .map(AgendamentoExibicaoDto::new)
                .toList();
    }
}
