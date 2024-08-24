package br.com.fiap.agendamento.repository;


import br.com.fiap.agendamento.model.Log;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
}
