package de.jknowledge.cdi.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Tracked
@Interceptor
public class TrackingInterceptor implements Serializable {

	public static int calls = 0;
	
	public static long lastProcessTime = 0l;
	
	@AroundInvoke
	public Object track(InvocationContext invocationContext) throws Exception {
		long timeBefore = System.currentTimeMillis();
		Object result = invocationContext.proceed();
		long timeAfter = System.currentTimeMillis();
		long processTime = timeAfter - timeBefore;
		calls ++;
		lastProcessTime = processTime;
		return result;
	}
	
}
