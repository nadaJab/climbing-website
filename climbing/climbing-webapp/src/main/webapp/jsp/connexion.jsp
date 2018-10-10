<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">  
    <sb:head/>
	<sj:head jquerytheme="lightness"/>
	 
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
                    placeholder="adresse@exemple.com"
                    tooltip="Votre adresse email"/> 
             
              <s:password
            		key="accountBean.password"/>  
            		           
              <s:submit value="Connecter" id="connecter" cssClass="btn btn-primary center-block"/>      
         </s:form>               
 	   	
 </div> 	   	
	 	   	<%@include file="include/footer.jsp" %>
</body>
</html>