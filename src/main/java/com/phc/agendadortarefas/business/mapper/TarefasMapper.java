package com.phc.agendadortarefas.business.mapper;

import com.phc.agendadortarefas.business.dto.TarefasDTO;
import com.phc.agendadortarefas.infra.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasMapper {

    TarefasEntity paraTarefaEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefaDTO(TarefasEntity tarefasEntity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> tarefasDTOList);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> tarefasEntityList);
}
