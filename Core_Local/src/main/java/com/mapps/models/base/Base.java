package com.mapps.models.base;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.mapps.utilities.Status;


public abstract class Base implements Serializable {

	private static final long serialVersionUID = -3779777204972733953L;

	@Id
	@NotNull(message = "model.base.id.not_null.error")
	@Size(max = 36, message = "model.base.id.size.error")
	protected String Id;
	
	@NotNull(message = "model.base.createBy.not_null.error")
	@Size(max = 50, message = "model.base.createdBy.size.error")
	@CreatedBy
	protected String createBy;
	
	@CreatedDate
	protected Date createDt;
	
	@Size(max = 50, message = "model.base.updateBy.size.error")
	@LastModifiedBy
	protected String updateBy;
	
	@LastModifiedDate
	protected Date updateDt;
	
	@NotNull(message = "model.base.status.not_null.error")
	protected Status status;
	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		if(createBy.trim().isEmpty()) this.createBy = null;
		else this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String toString() {
		return new ToStringBuilder(this).append("Id", this.Id).append("create by", this.createBy).
				append("create date", this.createDt).append("update by", this.updateBy).
				append("update date", this.updateDt).append("status", this.status).toString();
	}
	
	public void updateDetails(Base r) {
		if(this.status != r.getStatus()) {
			this.setStatus(r.getStatus());
		}
	}
}
