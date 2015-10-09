package com.qaiware.llamakisses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing a user.
 *
 * @author Venci
 */
@Entity
@Table(name = "users")
public class User extends Base {
	
	@Column(name = "email")
	@NotEmpty
	private String email;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "paymill_id")
	@NotEmpty
	private String paymill_id;

	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymill_id() {
		return paymill_id;
	}

	public void setPaymill_id(String paymill_id) {
		this.paymill_id = paymill_id;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
}