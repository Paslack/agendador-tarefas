package com.phc.agendadortarefas.controller;

import com.phc.agendadortarefas.business.dto.TarefasDTO;
import com.phc.agendadortarefas.business.service.TarefasService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscarTarefasPorPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscarTarefasPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

}
