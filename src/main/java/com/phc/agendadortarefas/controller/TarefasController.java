package com.phc.agendadortarefas.controller;

import com.phc.agendadortarefas.business.dto.TarefasDTO;
import com.phc.agendadortarefas.business.service.TarefasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestHeader("Authorization") String token,
                                                    @RequestBody TarefasDTO tarefasDTO) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(token, tarefasDTO));
    }
}
