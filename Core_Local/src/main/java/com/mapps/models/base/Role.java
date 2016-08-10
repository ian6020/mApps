package com.mapps.models.base;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Role extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307138340909519138L;
	
	@NotNull(message = "model.role.name.not_null.error")
	private String name;
	
	public Role(String role) {
		setName(role);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim().toUpperCase();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Id", this.Id)
				.append("role", this.name).toString();
	}

}
