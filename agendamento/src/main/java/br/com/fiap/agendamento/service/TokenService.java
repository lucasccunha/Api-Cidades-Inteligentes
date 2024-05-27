package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256("fiap");

        String token = JWT
                .create()
                .withIssuer("ads-fiap")
                .withSubject(user.getUsername())
                .withExpiresAt(gerarDataExpiracao())
                .sign(algorithm);


        return token;

    }
                private Instant gerarDataExpiracao(){
                    return LocalDateTime
                            .now()
                            .plusHours(2)
                            .toInstant(ZoneOffset.of("-03:00"));
        }

        public String validarToken(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("fiap");

            return JWT
                    .require(algorithm)
                    .withIssuer("ads-fiap")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }

    }

}
