package org.climbing.interceptor;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String USER = "user";
	private static final Logger LOGGER = LogManager.getLogger(LoginInterceptor.class);

	  @Override
	    public String intercept(ActionInvocation pInvocation) throws Exception {
	        String vResult;
			Map<String, Object> sessionAttributes = pInvocation.getInvocationContext().getSession();
			LOGGER.debug("Intercepteur !!!!!!!!!!!!!!");
	        if (sessionAttributes.get(USER) != null) {
	            vResult = pInvocation.invoke();
	        } else {
	            vResult = "error-forbidden";
	        }
	        return vResult;
	    }
	  
}
