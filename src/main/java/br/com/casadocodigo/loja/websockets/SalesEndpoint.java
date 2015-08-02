package br.com.casadocodigo.loja.websockets;

import javax.inject.Inject;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/channel/sales")
public class SalesEndpoint {
	
	@Inject
	private ConnectedUsers connectedUser;
	
	@OnOpen
	public void onNewUser(Session session){
		System.out.println("Principal "+session.getUserPrincipal());
		System.out.println("Adicionou? "+connectedUser.add(session));
	}
}
