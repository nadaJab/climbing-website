package org.climbing.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String USER = "user";

	  @Override
	    public String intercept(ActionInvocation pInvocation) throws Exception {
	        String vResult;
			Map<String, Object> sessionAttributes = pInvocation.getInvocationContext().getSession();
			
	        if (sessionAttributes.get(USER) != null) {
	            vResult = pInvocation.invoke();
	        } else {
	            vResult = "error-forbidden";
	        }
	        return vResult;
	    }
	/*
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String vResult;
		
		 Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		 if(sessionAttributes == null || sessionAttributes.get("use") == null) {
			 return "login";
		 }
		 else {
			 if (sessionAttributes.get("user").equals(null)){
				 vResult = invocation.invoke();
			 }
			 else {
		         vResult = "error-forbidden";
			 }
	}
	        return vResult;

} */
	  
}
