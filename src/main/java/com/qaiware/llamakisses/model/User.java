package com.qaiware.llamakisses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing a user.
 *
 * @author Venci
 */
@Entity
@Table(name = "users")
public class User extends Base {

	@Column(name = "email")
	@Email
	@NotEmpty(message = "Email can't be blank")
	private String email;

	@Column(name = "password")
	@NotEmpty(message = "Password can't be blank")
	private String password;

	@Transient
	private String passwordConfirm;

	@Column(name = "name")
	@NotEmpty(message = "Name can't be blank")
	private String name;

	@Column(name = "paymill_id")
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {

		return new ToStringCreator(this)

		.append("id", this.id).append("email", this.email).append("password", this.password).append("name", this.name)
				.append("paymill_id", this.paymill_id).append("offer", this.offer.getName()).toString();
	}

}