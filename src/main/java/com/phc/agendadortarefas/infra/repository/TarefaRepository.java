package com.phc.agendadortarefas.infra.repository;

import com.phc.agendadortarefas.infra.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefaRepository extends MongoRepository<TarefasEntity, String> {
    List<TarefasEntity> findByDataEventoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);

    List<TarefasEntity> findByEmailUsuario(String email);
}
