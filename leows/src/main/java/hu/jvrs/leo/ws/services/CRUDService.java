package hu.jvrs.leo.ws.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

/*
 * Generic Dao
 * http://www.javaworld.com/article/2078031/java-se/lean-service-architectures-with-java-ee-6.html?page=2
 */
@Local
public interface CRUDService {
	public <T> T create(T t);
    public <T> T find(Class<T> type,Object id);
    public <T> T update(T t);
    public void delete(Object t);
    public List<?> findWithNamedQuery(String queryName);
    public List<?> findWithNamedQuery(String queryName,int resultLimit);
    public List<?> findWithNamedQuery(String namedQueryName, Map<String,Object> parameters);
    public List<?> findWithNamedQuery(String namedQueryName, Map<String,Object> parameters,int resultLimit);
}
