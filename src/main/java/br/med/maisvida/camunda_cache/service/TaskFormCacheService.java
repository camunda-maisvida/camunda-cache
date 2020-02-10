package br.med.maisvida.camunda_cache.service;

import br.med.maisvida.camunda_cache.dto.TaskFormCacheDTO;

public interface TaskFormCacheService {

	void save(TaskFormCacheDTO taskCache);

	TaskFormCacheDTO findByTaskId(String taskId);

}
