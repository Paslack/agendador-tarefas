package com.phc.agendadortarefas.infra.repository;

import com.phc.agendadortarefas.infra.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<TarefasEntity, String> {

}
