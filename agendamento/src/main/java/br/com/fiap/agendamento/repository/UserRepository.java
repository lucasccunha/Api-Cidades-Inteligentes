package br.com.fiap.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.agendamento.model.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

}

