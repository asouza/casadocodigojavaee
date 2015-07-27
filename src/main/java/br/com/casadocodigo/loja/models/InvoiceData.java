package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import br.com.casadocodigo.models.Checkout;

public class InvoiceData  {

	private BigDecimal value;
	private String buyerEmail;

	public InvoiceData(Checkout checkout) {
		this.value = checkout.getValue();
		this.buyerEmail = checkout.getBuyer().getEmail();
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public String getBuyerEmail() {
		return buyerEmail;
	}

}
