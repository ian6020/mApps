package com.mapps.models.base;

import java.lang.String;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entity implementation class for Entity: Address
 *
 */

public class Address extends Base {
	
	private static final long serialVersionUID = -7830138994359068203L;

	protected String house;
	
	protected String block;
	
	@NotNull(message= "model.address.street1.not_null.error")
	@Size(max = 50, message = "model.address.street1.size.error")	
	protected String street1;
	
	@Size(max = 50, message = "model.address.street2.size.error")
	protected String street2;
	
	@NotNull(message= "model.address.postal.not_null.error")
	protected Integer postal;
	
	protected Integer countryCd;
	
	protected Integer areaCd;
	
	protected String fax;
	
	protected String tel;
	
	@NotNull(message= "model.address.city.not_null.error")
	@Size(max = 20, message = "model.address.city.size.error")
	protected String city;
	
	@Size(max = 20, message = "model.address.state.size.error")
	protected String state = null;
	
	@NotNull(message= "model.address.country.not_null.error")
	@Size(max = 30, message = "model.address.country.size.error")	
	protected String country;
	
	public Address() {
		super();
	}
	
	public Address(String owner, String house, String block, String street1, String street2, 
			int cntyCd, int areaCd, int zip, long fax, long tel, String city, 
			String state, String country) {
		this();
		this.block = block;
		this.house = house;
		this.street1 = street1.trim();
		this.street2 = street2.trim();
		this.postal = zip;
		this.fax = String.valueOf(fax);
		this.tel = String.valueOf(tel);
		this.areaCd = areaCd;
		this.countryCd = cntyCd;
		this.city = city.trim();
		this.state = state.trim();
		this.country = country.trim();
	}
	
	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		if(street1 == null || street1.trim().isEmpty()) this.street1 = null;
		else this.street1 = street1.trim();
	}
	
	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		if(street2 == null || street2.trim().isEmpty()) this.street2 = null;
		else this.street2 = street2.trim();
	}
	
	public Integer getPostal() {
		return this.postal;
	}

	public void setPostal(int postal) {
		if(postal <= 0) this.postal = null;
		else this.postal = postal;
	}
	
	public String getFax() {
		return this.fax;
	}

	public void setFaxByObject(String fax) {
		if(fax == null || fax.trim().isEmpty()) this.fax = null;
		else this.fax = fax.trim();
	}
	public void setFax(long fax) {
		this.fax = String.valueOf(fax);
	}
	public void setPhoneNumber(int cntry, int area, int num) {
		this.areaCd = area;
		this.countryCd = cntry;
		this.tel = String.valueOf(num);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		if(city == null || city.trim().isEmpty()) this.city = null;
		else this.city = city.trim();
	}
	
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		if(country == null || country.trim().isEmpty()) this.country = null;
		else this.country = country.trim();
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		if(state == null || state.trim().isEmpty()) this.state = null;
		else this.state = state.trim();
	}
	

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).
				append("house", this.house).
				append("block", this.block).append("street1", this.street1).
				append("street2", this.street2).append("city", this.city).
				append("state", this.state).append("country", this.country).
				append("postal", this.postal).append("phone", this.tel).
				append("fax", this.fax).toString();
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		if(house == null || house.trim().isEmpty()) this.house = null;
		else this.house = house;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		if(block == null || block.trim().isEmpty()) this.block = null;
		else this.block = block.trim();
	}

	public Integer getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(int countryCd) {
		this.countryCd = countryCd;
	}

	public Integer getAreaCd() {
		return areaCd;
	}

	public void setAreaCd(int areaCd) {
		this.areaCd = areaCd;
	}

	public String getTel() {
		return tel;
	}

	public void setTelByObject(String home) {
		if(home == null || home.trim().isEmpty()) this.tel = null;
		else this.tel = home.trim();
	}
	
	public void setTel(long home) {
		this.tel = String.valueOf(home);
	}
}
