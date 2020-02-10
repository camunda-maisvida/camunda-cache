package br.med.maisvida.camunda_cache.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "TaskForm")
@Table(name = "task_form", schema = "cache")
public class TaskFormCache implements Serializable {

	/** Field serialVersionUID. */
	private static final long serialVersionUID = -6382021911769686515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "task_id", unique = true, nullable = false, updatable = false)
	private String taskId;

	@NotBlank
	@Column(name = "json", nullable = false)
	private String json;

	public TaskFormCache() {

	}

	public TaskFormCache( Long id ) {

		super();
		this.id = id;
	}

	public TaskFormCache( String taskId, String json ) {

		super();
		this.taskId = taskId;
		this.json = json;
	}

	/**
	 * Get the value for <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Set the value for <code>id</code>.
	 *
	 * @param id
	 */
	public void setId(Long id) {

		this.id = id;
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

	/**
	 * Default description: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( taskId == null ) ? 0 : taskId.hashCode() );
		return result;
	}

	/**
	 * Default description: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskFormCache other = (TaskFormCache) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}

	/**
	 * Default description: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "TaskCache [" + ( id != null ? "id=" + id + ", " : "" ) + ( taskId != null ? "taskId=" + taskId + ", " : "" ) + ( json != null ? "json=" + json : "" ) + "]";
	}

}
