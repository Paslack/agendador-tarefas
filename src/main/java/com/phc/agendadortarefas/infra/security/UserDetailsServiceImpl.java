package com.phc.agendadortarefas.infra.security;


import com.phc.agendadortarefas.business.dto.UsuarioDTO;
import com.phc.agendadortarefas.infra.client.UsuarioClient;
import com.phc.agendadortarefas.infra.entity.Usuario;
import com.phc.agendadortarefas.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    private final UsuarioClient usuarioClient;

    public UserDetailsServiceImpl(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public UserDetails loadUserByUsername(String token, String email) {

        UsuarioDTO usuarioDTO = usuarioClient.buscarUsuarioPorEmail(token, email);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
