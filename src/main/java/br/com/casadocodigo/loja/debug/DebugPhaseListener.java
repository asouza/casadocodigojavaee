package br.com.casadocodigo.loja.debug;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

public class DebugPhaseListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent event) {		
		System.out.println("@after "+event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		if(event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
			HttpServletRequest req = (HttpServletRequest) event.getFacesContext().getExternalContext().getRequest();
			System.out.println("Principal "+req.getUserPrincipal());
		}
		System.out.println("@before "+event.getPhaseId());		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
