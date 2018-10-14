<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<sj:head jqueryui="true"/>
   		<sb:head includeScripts="true"/>
	</head>
</head>
<body>
 	   	<%@include file="include/menu.jsp" %>
	
	<div class="container">
    <s:actionerror/>
            <s:actionmessage/>
            <s:fielderror/>
            
            <s:form action="index" enctype="multipart/form-data" cssClass="form-horizontal"
                    label="Ajouter un nouveau topo">
                    
                    <s:textfield
                        key="nameTopo"
                        tooltip="Entrer le nom du Topo"/>
                        
                    <s:textfield
                        key="author"
                        tooltip="Entrer l'auteur du topo"/>
                    
                    <s:textfield
                        key="nbCopyMax"
                        tooltip="Donner le nombre d'exemplaires que vous disposez"/>  
                        
                     <s:textfield
                        key="editionYear"
                        tooltip="L'année d'édition du topo"/> 
                    
               		<s:file
                        key="picture"
                        tooltip="Télécharger une image de couverture du topo"/>
                        
                    <s:submit cssClass="btn btn-primary"/>
    		</s:form>
 	</div>  
 	   	<%@include file="include/footer.jsp" %>
</body>
</html>