<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   		<s:head/>
	</head>

<body>
 	   	<%@include file="include/menu.jsp" %>
 	   	
 	<div class="container">
     
            <s:form action="inscription" enctype="multipart/form-data" cssClass="form-horizontal" label="Créer un compte">
              
               <s:textfield key="userBean.last_name"/>
               <s:textfield key="userBean.first_name"/> 
               <s:textfield key="userBean.pseudo"/>
               <s:textfield key="userBean.birth_year" placeholder= "dd/MM/yyyy"/>         	
			   <s:radio key="userBean.sexe"
                        labelposition="inline"
                        list="{'Femme', 'Homme'}"
                        cssErrorClass="foo"/>
			   <s:checkboxlist key="userBean.climbing_type" labelposition="inline"
						list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"/>				     
               <s:textfield key="accountBean.email" placeholder="adresse@exemple.com"/>      
               <s:password key="accountBean.password"/>			           
               <s:submit value="submit" cssClass="btn btn-primary"/>
               
            </s:form>
 </div>
   			
 	   	<%@include file="include/footer.jsp" %>
</body>
</html>