package br.com.casadocodigo.resources;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;


@Path("payment")
public class PaymentResource {
	
	
	private ExecutorService executor = Executors.newFixedThreadPool(50);

	@GET @Path("/async/teste")
    public void longRunningOp(@Suspended final AsyncResponse ar) {		
        executor.submit( () -> {
                    try {
						Thread.sleep(3000);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
                    ar.resume(Response.seeOther(URI.create("http://localhost:8080/casadocodigo/site/carrinho.xhtml")));
        });
	}
	
}
