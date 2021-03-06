package br.med.maisvida.camunda_cache.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.med.maisvida.camunda_cache.dto.TaskFormCacheDTO;
import br.med.maisvida.camunda_cache.service.TaskFormCacheService;

@CrossOrigin
@RestController
@Validated
public class TaskFormCacheRestController {

	@Autowired
	private TaskFormCacheService service;

	@PostMapping(value = { "/task/cache", "/task/cache/" })
	public ResponseEntity<TaskFormCacheDTO> saveCache(@Valid @RequestBody @NotNull TaskFormCacheDTO taskCache) {

		try {

			service.save(taskCache);

			return new ResponseEntity<TaskFormCacheDTO>(taskCache, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping(value = { "/task/{taskId}/cache", "/task/{taskId}/cache/" })
	public ResponseEntity<TaskFormCacheDTO> buscarPorParametro(@Valid @PathVariable(value = "taskId") @NotNull String taskId) {

		final TaskFormCacheDTO response = service.findByTaskId(taskId);
		return response == null ? ResponseEntity.notFound().build() : new ResponseEntity<TaskFormCacheDTO>(response, HttpStatus.OK);

	}

	@GetMapping(value = { "/task/cache", "/task/cache/" })
	public ResponseEntity<List<TaskFormCacheDTO>> buscarTodos(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size) {

		final List<TaskFormCacheDTO> response = service.findAll(page, size);

		return response == null ? ResponseEntity.notFound().build() : new ResponseEntity<List<TaskFormCacheDTO>>(response, HttpStatus.OK);

	}

	@DeleteMapping(value = { "/task/{taskId}/cache", "/task/{taskId}/cache/" })
	public ResponseEntity<?> deletarCache(@Valid @PathVariable(value = "taskId") @NotNull String taskId) {

		boolean result = service.deleteByTaskId(taskId);

		return result ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();

	}

}
