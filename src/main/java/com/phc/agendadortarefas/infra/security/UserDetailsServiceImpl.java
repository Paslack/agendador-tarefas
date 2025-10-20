package com.phc.agendadortarefas.infra.security;


import com.phc.agendadortarefas.business.dto.UsuarioDTO;
import com.phc.agendadortarefas.infra.security.client.UsuarioClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    private final UsuarioClient usuarioClient;

    public UserDetailsServiceImpl(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public UserDetails carregaDadosUsuario(String email) {
        // Token é adicionado automaticamente pelo FeignConfig
        UsuarioDTO usuarioDTO = usuarioClient.buscarUsuarioPorEmail(email);
        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();
    }
}
