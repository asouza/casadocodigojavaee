package br.com.casadocodigo.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Checkout {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private SystemUser buyer;
	private String jsonCart;
	private BigDecimal value;

	protected Checkout() {

	}

	public Checkout(SystemUser user, ShoppingCart cart) {
		this.buyer = user;
		this.value = cart.getTotal();
		this.jsonCart = cart.toJson();
	}

	public SystemUser getBuyer() {
		return buyer;
	}

	public String getJsonCart() {
		return jsonCart;
	}

	public BigDecimal getValue() {
		return value;
	}

}
