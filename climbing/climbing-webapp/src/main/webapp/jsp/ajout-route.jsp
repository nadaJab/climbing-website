<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<s:head/>
	</head>
</head>
<body>
 	   	<%@include file="include/menu.jsp" %>
	
	<div class="container">
    <s:actionerror/>
            <s:actionmessage/>
            <s:fielderror/>
            
            <s:form action="index" enctype="multipart/form-data" cssClass="form-horizontal"
                    label="Ajouter une nouvelle ligne">
                    
                    <s:textfield
                        key="nameLigne"
                        tooltip="Entrer le nom de la nouvelle ligne"/>
                        
                    <s:select
                        key="cotation"
                        list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
                        headerKey="non-renseignée"
                        headerValue="non-renseignée"
                        emptyOption="true"	   
                        tooltip="La cotation de la ligne"/>
                    
                    <s:textfield
                        key="height"
                        tooltip="L'hauteur"/>  
                        
                     <s:textfield
                        key="pointNumber"
                        tooltip="le nombre des points"/> 
                    
               		<s:textfield
                        key="nomOuvreurs"
                        tooltip="Nom des ouvreurs de la ligne"/> 
                        
                    <s:textfield
                        key="openingYear"
                        tooltip="Année d'ouverture"/>     
                        
                    <s:submit cssClass="btn btn-primary"/>
    		</s:form>
 	</div>  
 		 	   	<%@include file="include/footer.jsp" %>
 		
</body>
</html>