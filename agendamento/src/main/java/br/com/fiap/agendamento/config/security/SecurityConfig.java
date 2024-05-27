package br.com.fiap.agendamento.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private VerificaToken verificarToken;


    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(
            HttpSecurity httpSecurity) throws Exception {



        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/agendamento").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/api/agendamento/id/").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/agendamento/atualizar").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/agendamento/buscar/id/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/agendamento/todos").hasAnyRole("USER","ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/agendamento/nome/{nome}").hasAnyRole("USER","ADMIN")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(verificarToken, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration  authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
