<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head> 
    <meta charset="UTF-8">  
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
                        key="nomUtilisation"
                        tooltip="Entrez votre nom d'utilisation"/>
                        
                <sj:datepicker
                        id="datepicker"
                        key="DateDeNaissance"
                        cssClass="form-control"
                        elementCssClass="col-sm-5"
                        showOn="focus"
                        inputAppendIcon="calendar"
                        tooltip="Votre date de naissance"
                        />
                   		          	
				<s:radio
                        key="sexe"
                        labelposition="inline"
                        list="{'Femme', 'Homme'}"
                        tooltip="Sexe"
                        cssErrorClass="foo"/>

				<s:checkboxlist
                        key="typeGrimpe"
                        labelposition="inline"
						list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"      
						tooltip="Type de grimpe"/>
						
				<s:textfield
                        key="pays"
                        tooltip="Votre pays"/>
						     
                <s:textfield
                        key="email"
                        placeholder="adresse@exemple.com"
                        tooltip="Enter your Name here"/>
                        
                <s:password
            			key="password"/>
            			
                <s:password
            			key="confirmerPassword"/>			
                              
                  <s:submit cssClass="btn btn-primary"/>
            </s:form>
 </div>  
</body>
</html>