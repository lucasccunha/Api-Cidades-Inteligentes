package br.com.fiap.agendamento.repository;


import br.com.fiap.agendamento.model.Servico;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicoRepository extends MongoRepository<Servico, ObjectId> {
}

