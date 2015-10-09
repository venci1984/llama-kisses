package com.qaiware.llamakisses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing a user role.
 *
 * @author Venci
 */
@Entity
@Table(name = "user_roles")
public class UserRole extends Base{

	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
