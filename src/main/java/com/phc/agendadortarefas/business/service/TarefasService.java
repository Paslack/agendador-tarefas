package com.phc.agendadortarefas.business.service;

import com.phc.agendadortarefas.business.dto.TarefasDTO;
import com.phc.agendadortarefas.business.mapper.TarefasMapper;
import com.phc.agendadortarefas.infra.entity.TarefasEntity;
import com.phc.agendadortarefas.infra.enums.StatusNotificacaoEnum;
import com.phc.agendadortarefas.infra.repository.TarefaRepository;
import com.phc.agendadortarefas.infra.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefasService {

    private final TarefaRepository tarefaRepository;
    private final TarefasMapper tarefasMapper;
    private final JwtUtil jwtUtil;

    public TarefasService(TarefaRepository tarefaRepository, TarefasMapper tarefasMapper, JwtUtil jwtUtil) {
        this.tarefaRepository = tarefaRepository;
        this.tarefasMapper = tarefasMapper;
        this.jwtUtil = jwtUtil;
    }

    public TarefasDTO gravarTarefas(String token, TarefasDTO tarefasDTO) {
        String email = jwtUtil.extractUsername(token.substring(7));
        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        tarefasDTO.setEmailUsuario(email);
        TarefasEntity tarefasEntity = tarefasMapper.paraTarefaEntity(tarefasDTO);
        tarefaRepository.save(tarefasEntity);

        return tarefasMapper.paraTarefaDTO(tarefasEntity);
    }

    public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        List<TarefasEntity> byDataEventoBetween = tarefaRepository.findByDataEventoBetween(dataInicial, dataFinal);
        return tarefasMapper.paraListaTarefasDTO(byDataEventoBetween);
    }

    public List<TarefasDTO> buscarTarefasPorEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        List<TarefasEntity> listTarefasEntity = tarefaRepository.findByEmailUsuario(email);
        return tarefasMapper.paraListaTarefasDTO(listTarefasEntity);
    }


}
