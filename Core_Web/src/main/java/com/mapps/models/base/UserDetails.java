package com.mapps.models.base;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.mapps.exception.ApplicationException;
import com.mapps.utilities.Gender;
import com.mapps.utilities.Salutation;

/**
 * abstract class for user and contacts details
 *
 */
public abstract class UserDetails extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -72029587043950383L;

	@NotNull(message = "model.user.details.satutation.not_null.error")
	protected Salutation salutation;
	
	@NotNull(message = "model.user.details.gender.not_null.error")
	protected Gender gender;
	
	@NotNull(message = "model.user.details.firstname.not_null.error")
	@Size(max = 20, message = "model.user.details.firstname.size.error")
	protected String firstname;
	
	@NotNull(message = "model.user.details.lastname.not_null.error")
	@Size(max = 20, message = "model.user.details.lastname.size.error")
	protected String lastname;
	
	@Size(max = 20, message = "model.user.details.middlename.size.error")
	protected String middlename;
	
	protected Date birthday;
	
	@Size(max = 50, message = "model.user.details.email.size.error")
	protected String email;
	
	@NotNull(message = "model.user.details.countryCd.not_null.error")
	protected Integer countryCd;
	
	@NotNull(message = "model.user.details.areaCd.not_null.error")
	protected Integer areaCd;
	
	@NotNull(message = "model.user.details.phone.not_null.error")
	protected String phone;
	
	@Size(max = 150, message = "model.user.details.photo.size.error")
	protected String photo = "resources/img/signup/male.jpg";
	
	public Salutation getSalutation() {
		return this.salutation;
	}
	
	public void setSalutation(String salutation) throws ApplicationException {
		try {
			this.salutation = Salutation.valueOf(salutation.toUpperCase().trim());
		} catch (IllegalArgumentException e) {
			throw new ApplicationException("Invalid Salutation["+ salutation +"]", e);
		}
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		if(firstname.trim().isEmpty()) this.firstname = null;
		else this.firstname = firstname.trim();
	}
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname(String lastname) {
		if(lastname.trim().isEmpty()) this.lastname = null;
		else this.lastname = lastname.trim();
	}
	public String getMiddlename() {
		return this.middlename;
	}
	public void setMiddlename(String middlename) {
		if(middlename != null) 
			this.middlename = middlename.trim();
	}
	public void setPhoneNumber(int cntry, int area, int num) {
		this.areaCd = area;
		this.countryCd = cntry;
		this.phone = String.valueOf(num);
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(long phone) {
		this.phone = String.valueOf(phone);
	}
	
	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		if(photo != null) this.photo = photo.trim();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null) this.email = email.trim();
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(String gender) throws ApplicationException {
		try {
			this.gender = Gender.valueOf(gender.toUpperCase().trim());
		} catch (IllegalArgumentException e) {
			throw new ApplicationException("Invalid Gender["+ gender +"]", e);
		}
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("gender", this.gender)
				.append("salutation", this.salutation).append("firstname", this.firstname)
				.append("lastname", this.lastname).append("middlename", this.middlename)
				.append("birthday", this.birthday).append("email", this.email)
				.append("countryCd", this.countryCd).append("areaCd", this.areaCd)
				.append("phone", this.phone).append("photo", this.photo)
				.appendSuper(super.toString()).toString();
	}
	public Integer getCountryCd() {
		return countryCd;
	}
	public void setCountryCd(Integer countryCd) {
		if(countryCd == null ) this.countryCd = 0; 
		else this.countryCd = countryCd;
	}
	public Integer getAreaCd() {
		return areaCd;
	}
	public void setAreaCd(Integer areaCd) {
		if(areaCd == null ) this.areaCd = 0; 
		else this.areaCd = areaCd;
	}
		
}
