package br.med.maisvida.camunda_cache.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.med.maisvida.camunda_cache.dto.TaskFormCacheDTO;
import br.med.maisvida.camunda_cache.entity.TaskFormCache;
import br.med.maisvida.camunda_cache.repository.TaskFormCacheRepositorio;
import br.med.maisvida.camunda_cache.service.TaskFormCacheService;

@Service
@Transactional(readOnly = true)
public class TaskFormCacheServiceImpl implements TaskFormCacheService {

	@Autowired
	private TaskFormCacheRepositorio repository;

	@Override
	@Transactional(readOnly = false)
	public void save(TaskFormCacheDTO taskCache) {

		if (taskCache == null || !taskCache.hasParameters()) {
			throw new IllegalStateException("TaskID e JSON são obrigatórios");
		}

		TaskFormCache entity = this.repository.findByTaskId(taskCache.getTaskId()).orElse(new TaskFormCache(taskCache.getTaskId(), taskCache.getJson()));

		this.repository.save(entity);

	}

	@Override
	public TaskFormCacheDTO findByTaskId(String taskId) {

		if (StringUtils.isNotBlank(taskId)) {
			TaskFormCache entity = this.repository.findByTaskId(taskId).orElse(null);
			return entity != null ? new TaskFormCacheDTO(entity.getTaskId(), entity.getJson()) : null;
		}
		return null;
	}

}
