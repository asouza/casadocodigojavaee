package br.com.casadocodigo.loja.models;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

@Stateless
public class BroadcastCheckout {

	@Inject
	private JMSContext jmsContext;
	@Resource(lookup = "java:/jms/topics/checkoutsTopic")
	private Destination checkoutsTopic;
	
	public void execute(Checkout checkout){
		jmsContext.createProducer().send(checkoutsTopic, checkout.getUuid());
	}
}
