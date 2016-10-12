package br.com.casadocodigo.loja.websockets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ConnectedUsers {

	private Set<Session> remoteUsers = new HashSet<>();
	private Logger logger = LoggerFactory.getLogger(ConnectedUsers.class);
	
	public boolean add(Session remoteUser) {
		return this.remoteUsers.add(remoteUser);
	}
	
	public void send(String message) {
			for (Session user : remoteUsers) {
				if (user.isOpen()) {
					try {
						Basic basicRemote = user.getBasicRemote();
						basicRemote.sendText(message);
					} catch (IOException e) {
						logger.error("Não foi possivel enviar mensagem para um cliente, {}",e);
					}
				} else {
					System.out.println("cliente nao esta mais aberto");
				}
			}
	}

	public boolean remove(Session session) {
		return remoteUsers.remove(session);
	}
}
