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
            <s:fielderror/>
            
            <s:form action="index" enctype="multipart/form-data" cssClass="form-horizontal"
                    label="Ajouter un nouveau site">
                    
                    <s:textfield
                        key="nameSpot"
                        tooltip="Entrer le nom du site"/>
                        
                    <s:textfield
                        key="nbRouteTotal"
                        tooltip="Entrer le nombre total de voies"/>
                    
                    <s:select
                    	key="cotationMin"
                        list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
                        emptyOption="true"
                        tooltip="La cotation minimale du site"
                        headerKey="non-renseignée"
                        headerValue="non-renseignée"/>   
                        
                     <s:select
                     	key="cotationMax"
                        list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
                        emptyOption="true"
                        tooltip="La cotation maximale du site"
                        headerKey="non-renseignée"
                        headerValue="non-renseignée"/>        
                    
                    <s:checkboxlist
                    	key="orientation"
                        labelposition="inline"
						list="{'N', 'NE', 'E', 'SE', 'S', 'SO', 'O', 'NO'}"      
						tooltip="Orientations du site"/>
						
					<s:checkboxlist
						key="typeGrimpe"
                        labelposition="inline"
						list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"      
						tooltip="Type de grimpe"/>	
                    
                     <s:textfield
                        key="pays"
                        tooltip="Entrer le nom du pays"/>
                        
                     <s:textfield
                        key="ville"
                        tooltip="Entrer le nom de la ville"/>   
                        
                    <s:submit cssClass="btn btn-primary"/>
    		</s:form>
 	</div> 
 	   	<%@include file="include/footer.jsp" %>
</body>
</html>