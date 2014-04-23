package hu.jvrs.leo.ws.services.beans;

import hu.jvrs.leo.jpa.afakulcs.AfakulcsAlap;
import hu.jvrs.leo.ws.responses.AfakulcsValaszTipus;
import hu.jvrs.leo.ws.services.AfakulcsService;
import hu.jvrs.leo.ws.services.CRUDService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class AfakulcsServiceBean implements AfakulcsService {
	
	@EJB
	private CRUDService crud;	

	@Override
	@WebMethod
	public String getAllAfakulcsKodEs() {
		return crud.findWithNamedQuery(AfakulcsAlap.class.getSimpleName() + ".findAll").toString();
	}

	@Override
	@WebMethod
	public String getAfakulcsKodEsById(long id) {
		return crud.find(AfakulcsAlap.class, id).getGyujtoKod();
	}
	
	@Override
	@WebMethod
	public AfakulcsValaszTipus getAfakulcsById(long id) {
		AfakulcsValaszTipus avt = new AfakulcsValaszTipus();
		avt.setAfakulcsAlap(crud.find(AfakulcsAlap.class, id));		
		return avt;
	}

	public void setCrud(CRUDService crud) {
		this.crud = crud;
	}
}
