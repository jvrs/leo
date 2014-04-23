package hu.jvrs.leo.ws.services.tests;

import static org.junit.Assert.assertNotNull;
import hu.jvrs.leo.ws.services.AfakulcsService;
import hu.jvrs.leo.ws.services.CRUDService;
import hu.jvrs.leo.ws.services.beans.AfakulcsServiceBean;
import hu.jvrs.leo.ws.services.beans.CRUDServiceBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfakulcsServiceTest {
	private static final Logger SLF4JLOGGER = LoggerFactory.getLogger(AfakulcsServiceTest.class.getSimpleName());	
	private long startTime;
	
	private static final String DEFAULT_TEST_PU_NAME = "leojpaunit";
	private EntityManager entityManager;
	private CRUDService crud;
	private AfakulcsService service;
	
	@Before
	public void setUp() {
		startTime = System.nanoTime();
		
		AfakulcsServiceBean bean = new AfakulcsServiceBean(); 
		setupEntityManager();		
		crud = setupCRUDService();
		bean.setCrud(crud);
		service = bean;
	}
	
	private void setupEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(DEFAULT_TEST_PU_NAME);
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	private CRUDServiceBean setupCRUDService() {
		CRUDServiceBean daoBean = new CRUDServiceBean();
		daoBean.setEm(entityManager);
		return daoBean;
	}
	
	@Test
	public void test() {	
		assertNotNull(service.getAllAfakulcsKodEs());
//		assertNotNull(service.getAfakulcsKodEsById(1));
		SLF4JLOGGER.info("Test successfully finished!");
	}

	@After
	public void tearDown() {
		entityManager.getTransaction().rollback();
		double durationInSeconds = (double)(System.nanoTime() - startTime)/1000000000.0;
		SLF4JLOGGER.info("Test duration was: " + durationInSeconds + " secs!");
	}
}
