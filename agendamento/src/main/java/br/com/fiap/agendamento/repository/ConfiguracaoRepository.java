package br.com.fiap.agendamento.repository;


import br.com.fiap.agendamento.model.Configuracao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfiguracaoRepository extends MongoRepository<Configuracao, ObjectId> {
}
