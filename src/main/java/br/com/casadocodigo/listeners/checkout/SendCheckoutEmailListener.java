package br.com.casadocodigo.listeners.checkout;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationLookup", 
				propertyValue = "java:/jms/topics/checkoutsTopic") 
		})
public class SendCheckoutEmailListener implements MessageListener{
	
	private Logger logger = LoggerFactory.getLogger(SendCheckoutEmailListener.class);

	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage) message;
		try {
			System.out.println("Enviando email "+text.getText());
		} catch (JMSException e) {
			logger.error("Problema no envio do email",e);
		}
	}

}
