package com.phc.agendadortarefas.infra.security.client;

import com.phc.agendadortarefas.business.dto.UsuarioDTO;
import com.phc.agendadortarefas.infra.security.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}", configuration = FeignConfig.class)
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscarUsuarioPorEmail(@RequestParam("email") String email);
    // ⬆️ Removemos o @RequestHeader - o FeignConfig adiciona automaticamente!
}