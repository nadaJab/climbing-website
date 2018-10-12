<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<s:head/>
</head>

<body>
 	   	<%@include file="include/menu.jsp" %>
 	   	
 	   	<div class="container">
    		    	<s:actionerror/>
    	            <s:actionmessage/>
    	
         <s:form action="login" cssClass="form-horizontal"
                    label="Connexion">
                    
             <s:textfield
                    key="accountBean.email"
                    placeholder="adresse@exemple.com"/> 
             
              <s:password
            		key="accountBean.password"/>  
            		           
              <s:submit value="Connecter" id="connecter" cssClass="btn btn-primary center-block"/>      
         </s:form>               
 	   	
 </div> 	   	
	 	   	<%@include file="include/footer.jsp" %>
</body>
</html>