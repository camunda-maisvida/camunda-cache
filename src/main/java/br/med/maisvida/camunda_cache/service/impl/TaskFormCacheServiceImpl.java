package br.med.maisvida.camunda_cache.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	@Transactional(readOnly = false)
	public boolean deleteByTaskId(String taskId) {

		boolean result = false;
		if (StringUtils.isNotBlank(taskId)) {
			Optional<TaskFormCache> task = this.repository.findByTaskId(taskId);
			if (task.isPresent()) {
				this.repository.delete(task.get());
				result = true;
			}
		}

		return result;

	}

	@Override
	public List<TaskFormCacheDTO> findAll(Integer page, Integer size) {

		List<TaskFormCache> resultado = new ArrayList<>();

		if (temNumeroValido(page) && temNumeroValido(size)) {

			Pageable paginacao = PageRequest.of(page, size);

			final Page<TaskFormCache> paginaResult = this.repository.findAll(paginacao);

			resultado = paginaResult.getContent();
		} else {
			resultado = this.repository.findAll();
		}
		
		return resultado.stream()
				.map(m -> new TaskFormCacheDTO(m))
				.collect(Collectors.toList());
	}

	// TODO extrair para Utilitario
	private boolean temNumeroValido(Integer valor) {

		return valor != null && valor >= 0;
	}

}
