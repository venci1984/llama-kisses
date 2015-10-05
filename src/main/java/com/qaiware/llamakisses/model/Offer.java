package com.qaiware.llamakisses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing an offer.
 *
 * @author Venci
 */
@Entity
@Table(name = "offers")
public class Offer extends Base {
	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "amount")
	@NotEmpty
	private Integer amount;

	@Column(name = "paymill_id")
	@NotEmpty
	private String paymill_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPaymill_id() {
		return paymill_id;
	}

	public void setPaymill_id(String paymill_id) {
		this.paymill_id = paymill_id;
	}
}
