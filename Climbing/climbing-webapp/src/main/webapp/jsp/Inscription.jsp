<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head> 
    <meta charset="UTF-8">
    
<sb:head/>
</head>

<body>
 	<jsp:include page="Menu.jsp"></jsp:include> 
 	<div class="container">
    <s:actionerror/>
            <s:actionmessage/>
            <s:fielderror/>
            
            <s:form action="index" enctype="multipart/form-data" cssClass="form-horizontal"
                    label="Créer un compte">
                <s:textfield
                        key="name"
                        tooltip="Entrer votre nom"/>

                 <s:textfield
                 		key="firstName"
                 		tooltip="Entrer votre prénom"/>
                
                <s:textfield
                        label="Nom d'utilisation"
                        name="nom_utilisation"
                        tooltip="Entrer votre prénom"/>
				
				<s:radio
                        tooltip="Radio Buttons with inline position"
                        label="Sexe"
                        labelposition="inline"
                        list="{'Femme', 'Homme'}"
                        name="Sxe"
                        cssErrorClass="foo"/>

                <s:select
                        tooltip="Type de grimpe"
                        label="Type de grimpe"
                        list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"
                        name="Typedegrimpe"
                        emptyOption="true"
                        headerKey="None"
                        headerValue="Type de grimpe"/>

                        
                  <s:submit cssClass="btn"/>
            </s:form>
 </div>                       
</body>
</html>