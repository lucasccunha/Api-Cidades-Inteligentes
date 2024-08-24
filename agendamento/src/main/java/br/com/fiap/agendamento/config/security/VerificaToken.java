package br.com.fiap.agendamento.config.security;

import br.com.fiap.agendamento.repository.UserRepository;
import br.com.fiap.agendamento.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class VerificaToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
//teste
    @Autowired
    private UserRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String token = "";

        if (authorizationHeader == null) {
            System.out.println("Authorization header is missing");
            token = null;
        } else {
            token = authorizationHeader.replace("Bearer", "").trim();
            String login = tokenService.validarToken(token);
            System.out.println("Login from token: " + login);
            UserDetails usuario = usuarioRepository.findByEmail(login);

            if (usuario != null) {
                System.out.println("User found: " + usuario.getUsername());
                System.out.println("Authorities: " + usuario.getAuthorities());

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                usuario,
                                null,
                                usuario.getAuthorities()
                        );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                System.out.println("Usuário não encontrado ou token inválido");
            }
        }
        filterChain.doFilter(request, response);
    }
}



