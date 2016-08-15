package com.mapps.models.base;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;

public class Role extends Base implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307138340909519138L;
	
	@NotNull(message = "model.role.name.not_null.error")
	private String name;
	
	public Role(String name) {
		super();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim().toUpperCase();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Id", this.id)
				.append("role", this.name).toString();
	}

	@Override
	public String getAuthority() {
		return this.name;
	}

}
