package hu.jvrs.lion.ws.services;

import hu.jvrs.lion.jpa.afakulcs.AfakulcsAlap;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AfakulcsDao {
	public List<AfakulcsAlap> getAllAfakulcs();
	public AfakulcsAlap getAfakulcsById(long id);
}
