package com.phc.agendadortarefas.business.mapper;

import com.phc.agendadortarefas.business.dto.TarefasDTO;
import com.phc.agendadortarefas.infra.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasMapper {

    TarefasEntity paraTarefaEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefaDTO(TarefasEntity tarefasEntity);
}
