package br.com.casadocodigo.listeners.checkout;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.casadocodigo.daos.CheckoutDAO;
import br.com.casadocodigo.models.Checkout;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationLookup", 
				propertyValue = "java:/jms/topics/checkoutsTopic") 
		})
public class SendCheckoutEmailListener implements MessageListener{
	
	private Logger logger = LoggerFactory.getLogger(SendCheckoutEmailListener.class);
	@Resource(mappedName = "java:jboss/mail/gmail")
	private Session session;
	@Inject
	private CheckoutDAO checkoutDao;

	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage) message;
		try {
			Checkout checkout = checkoutDao.findByUuid(text.getText());
			
			javax.mail.Message mimeMessage = new MimeMessage(session);
			mimeMessage.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse("alots.ssa@gmail.com"));
			
			mimeMessage.setSubject("Sua compra foi registrada");			
			mimeMessage.setContent("<html><body>Compra realizada com sucesso. O código de acompanhamento é "+checkout.getUuid()+"</body></html>","text/html");

			Transport.send(mimeMessage);			
		} catch (Exception e) {
			logger.error("Problema no envio do email",e);
		}
	}

}
