package br.com.casadocodigo.loja.websockets;

import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/channel/sales")
public class SalesEndpoint {
	
	@Inject
	private ConnectedUsers connectedUsers;
	
	@OnOpen
	public void onNewUser(Session session){
		connectedUsers.add(session);
	}
	
	@OnClose
	public void onClose(Session session,CloseReason closeReason) {
		System.out.println(connectedUsers.remove(session));
		System.out.println(closeReason.getCloseCode());
	}
}
