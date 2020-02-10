package br.med.maisvida.camunda_cache.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.med.maisvida.camunda_cache.entity.TaskFormCache;

@Repository
public interface TaskFormCacheRepositorio extends JpaRepository<TaskFormCache, Long> {

	Optional<TaskFormCache> findByTaskId(String taskId);

}
