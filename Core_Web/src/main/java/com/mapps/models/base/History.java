package com.mapps.models.base;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.mapps.utilities.Status;


public class History extends Base {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9141282167420185378L;
	
	@NotNull(message = "model.history.entity.not_null.error")
	@Size(max = 36, message = "model.history.entity.size.error")
	protected String entity;
	
	@NotNull(message = "model.history.description.not_null.error")
	@Size(max = 250, message = "model.history.description.size.error")
	protected String description;
	
	public History() {
		super();
		this.status = Status.CREATION;
	}
	
	public History(String Id, String user, String description) {
		this.entity = Id;
		this.createBy = user;
		this.description = description;
		this.status = Status.CREATION;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		if(entity.trim().isEmpty()) this.entity = null;
		else this.entity = entity.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description.trim().isEmpty()) this.description = null;
		else this.description = description.trim();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Id", this.id)
				.append("Entity", this.entity).append("Description", this.description).toString();
	}
	
}
