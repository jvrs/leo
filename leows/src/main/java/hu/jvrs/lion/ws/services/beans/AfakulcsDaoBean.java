package hu.jvrs.lion.ws.services.beans;

import hu.jvrs.lion.jpa.afakulcs.AfakulcsAlap;
import hu.jvrs.lion.ws.services.AfakulcsDao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AfakulcsDaoBean implements AfakulcsDao{
	
	@PersistenceContext(unitName = "lion5jpaunit", name = "lion5jpaunit")
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
