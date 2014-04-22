package hu.jvrs.lion.ws.interceptors;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fingerceptor {
	private static final Logger SLF4JLOGGER = LoggerFactory.getLogger(Fingerceptor.class.getSimpleName());	
	private static long startTime;
	
	@Resource
	private EJBContext ejbContext;
	
	@AroundInvoke
	public Object logContext(InvocationContext ctx) throws Exception {
		final String forrasEjb = ctx.getTarget().toString();
//		final String forrasMethod = ctx.getMethod().getName();
		
		startTime = System.nanoTime();
		Object result = ctx.proceed();
		double durationInSeconds = (double) (System.nanoTime() - startTime)	/ (1000.0 * 1000.0 * 1000.0);
		SLF4JLOGGER.info("EJB (" + forrasEjb + ") run duration: " + durationInSeconds + " secs!");
		
		return result;
	}

}
