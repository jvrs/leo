package hu.jvrs.leo.ws.services.beans;

import hu.jvrs.leo.jpa.afakulcs.AfakulcsAlap;
import hu.jvrs.leo.ws.services.AfakulcsDao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AfakulcsDaoBean implements AfakulcsDao{
	
	@PersistenceContext(unitName = "leojpaunit", name = "leojpaunit")
	private EntityManager em;

	@Override
	public List<AfakulcsAlap> getAllAfakulcs() {
		Query query = em.createNamedQuery(AfakulcsAlap.class.getName() + ".findAll");		
		
		@SuppressWarnings("unchecked")
		List<AfakulcsAlap> results = query.getResultList();		
		return results;
	}

	@Override
	public AfakulcsAlap getAfakulcsById(long id) {
		return em.find(AfakulcsAlap.class, id);
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
