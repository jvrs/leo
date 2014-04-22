package hu.jvrs.lion.ws.services.beans;

import hu.jvrs.lion.ws.interceptors.Fingerceptor;
import hu.jvrs.lion.ws.services.CRUDService;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Interceptors(Fingerceptor.class)
public class CRUDServiceBean implements CRUDService {
	private static final Logger SLF4JLOGGER = LoggerFactory.getLogger(CRUDServiceBean.class.getSimpleName());	
	private Integer methodCallsNo;
	private static Integer instanceNo;

	@PersistenceContext(unitName = "lion5jpaunit", name = "lion5jpaunit")
	private EntityManager em;
	
	static {
		SLF4JLOGGER.info("--== CRUDServiceBean static initializer==--");
		instanceNo = 0;
	}
	
	public CRUDServiceBean(){		
		methodCallsNo = 0;
		instanceNo++;
		SLF4JLOGGER.info("--== CRUDServiceBean constructor, creating instance {" + this.toString() + "}, number of instances: " + instanceNo + "==--");
	}

	public <T> T create(T t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	public <T> T find(Class<T> type, Object id) {
		methodCallsNo++;
		SLF4JLOGGER.info("--== Method {find} run in class instance {" + this.toString() + "} "  + methodCallsNo + " times==--");
		return (T) this.em.find(type, id);
	}

	public void delete(Object t) {
		Object ref = this.em.getReference(t.getClass(), t);
		this.em.remove(ref);
	}

	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	public List<?> findWithNamedQuery(String namedQueryName) {
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	public List<?> findWithNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	public List<?> findWithNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	public List<?> findByNativeQuery(String sql, Class<?> type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

	public List<?> findWithNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
		
	public Integer getInstanceNo() {
		return instanceNo;
	}
}
