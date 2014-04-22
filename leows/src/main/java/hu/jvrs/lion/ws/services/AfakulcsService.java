package hu.jvrs.lion.ws.services;

import hu.jvrs.lion.ws.responses.AfakulcsValaszTipus;

import javax.ejb.Remote;

@Remote
public interface AfakulcsService {	
	public String getAllAfakulcsKodEs();
	public String getAfakulcsKodEsById(long id);
	public AfakulcsValaszTipus getAfakulcsById(long id);
}
