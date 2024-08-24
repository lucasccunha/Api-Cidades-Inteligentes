package br.com.fiap.agendamento.repository;

import br.com.fiap.agendamento.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends MongoRepository<User, ObjectId> {

    UserDetails findByEmail(String email);

}

