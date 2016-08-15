package com.mapps.models.base;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.mapps.exception.ApplicationException;

public class Organization extends Base {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -994928065140299839L;

	@NotNull(message = "model.organization.name.not_null.error")
	protected String name;
	
	protected String description;
	
	protected String licence;
	
	public Organization() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws ApplicationException{
		if(name.trim().isEmpty()) throw new ApplicationException("Invalie Organization's name[" + name + "]");
		else this.name = name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	
	public boolean equals(Organization trader) {
		boolean ret = false;
		if(this.name.equalsIgnoreCase(trader.getName()))
			ret = true;
		return ret;
	}
	
	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Id", this.id)
				.append("organization", this.name)
				.append("licence", this.licence)
				.append("description", this.description).toString();
	}
}
