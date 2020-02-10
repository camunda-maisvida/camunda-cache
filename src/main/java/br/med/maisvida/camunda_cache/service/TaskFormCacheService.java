package br.med.maisvida.camunda_cache.service;

import java.util.List;

import br.med.maisvida.camunda_cache.dto.TaskFormCacheDTO;

public interface TaskFormCacheService {

	void save(TaskFormCacheDTO taskCache);

	TaskFormCacheDTO findByTaskId(String taskId);

	boolean deleteByTaskId(String taskId);

	List<TaskFormCacheDTO> findAll(Integer page, Integer size);

}
