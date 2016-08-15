package com.mapps.models.base;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.mapps.exception.ApplicationException;
import com.mapps.utilities.MCrypt;

/**
 * Entity implementation class for Entity: User
 *
 */

public class User extends UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5132551267881253806L;

	/*
	 * List of address of this user
	 * */
	@Valid
	protected Address address;
	
	@NotNull(message = "model.user.role.not_null.error")
	protected List<Role> role;
	
	@NotNull(message = "model.user.username.not_null.error")
	@Size(max = 50, message = "model.user.username.size.error")
	protected String username;
	
	@NotNull(message = "model.user.password.not_null.error")
	@Size(max = 50, message = "model.user.password.size.error")
	protected String password = null;
	
	protected Boolean isMain = false;
	
	protected Organization organization;
	
	public User() {
		super();
		role = new ArrayList<Role>();
	}
	
	/**
	 *  Use only for Sign-up page
	 * @param username username
	 * @param password password
	 * @param fname firstname
	 * @param lname lastname
	 * @param email email add
	 */
	public User(String username, String password, String fname, String lname, String email) {
		this();
		this.username = username;
		this.firstname = fname.toUpperCase();
		this.lastname = lname.toUpperCase();
		this.email = email;
		this.password = password;
		role.add(new Role("ADMIN"));
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
		}
	}
	
	public List<Role> getRole() {
		return this.role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = MCrypt.crypt(password);
	}

	public void setRole(String r) {
		if(r.trim().isEmpty()) throw new ApplicationException("Invalid role[" + r +"]");
		else this.role.add(new Role(r));
	}
	
	public void setRole(List<Role> r) {
		this.role = r;
	}
	
	public void setRole(Role role) {
		this.role.add(role);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) throws ApplicationException {
		if(username.trim().isEmpty()) throw new ApplicationException("Invalid username[" + username +"]");
		else this.username = username.trim();
	}
	
	
	public Boolean getIsMain() {
		return this.isMain;
	}

	public void setIsMain(boolean isLock) {
		this.isMain = isLock;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization trader) {
		this.organization = trader;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Id", this.id)
				.append("role", this.role).append("username", this.username)
				.append("isMain", this.isMain).append("address", this.address)
				.appendSuper(super.toString()).toString();
	}
}
