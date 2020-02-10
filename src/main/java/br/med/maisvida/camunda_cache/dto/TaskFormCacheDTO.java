package br.med.maisvida.camunda_cache.dto;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;

public class TaskFormCacheDTO {

	@NotBlank
	private String taskId;

	@NotBlank
	private String json;

	public TaskFormCacheDTO() {

	}

	public TaskFormCacheDTO( String taskId, String json ) {

		super();
		this.taskId = taskId;
		this.json = json;
	}

	/**
	 * Get the value for <code>taskId</code>
	 *
	 * @return <code>String</code>
	 */
	public String getTaskId() {

		return taskId;
	}

	/**
	 * Set the value for <code>taskId</code>.
	 *
	 * @param taskId
	 */
	public void setTaskId(String taskId) {

		this.taskId = taskId;
	}

	/**
	 * Get the value for <code>json</code>
	 *
	 * @return <code>String</code>
	 */
	public String getJson() {

		return json;
	}

	/**
	 * Set the value for <code>json</code>.
	 *
	 * @param json
	 */
	public void setJson(String json) {

		this.json = json;
	}

	public boolean hasParameters() {

		return StringUtils.isNotBlank(this.taskId) && StringUtils.isNotBlank(this.json);
	}

}
