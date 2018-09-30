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
                    label="Créer un compte">
               <s:textfield
                        key="user.last_name"/>

                 <s:textfield
                 		key="user.first_name"/>
                
                <s:textfield
                        key="user.pseudo"/>
                        
                <sj:datepicker
                        id="datepicker"
                        key="user.birth_year"
                        cssClass="form-control"
                        elementCssClass="col-sm-5"
                        showOn="focus"
                        inputAppendIcon="calendar"/>
                   		          	
				<s:radio
                        key="user.sexe"
                        labelposition="inline"
                        list="{'Femme', 'Homme'}"
                        cssErrorClass="foo"/>

				<s:checkboxlist
                        key="user.climbing_type"
                        labelposition="inline"
						list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"/>
								     
                <s:textfield
                        key="account.email"
                        placeholder="adresse@exemple.com"/>
                        
                <s:password
            			key="account.password"/>			
                              
                  <s:submit key="submit" cssClass="btn btn-primary"/>
            </s:form>
 </div>
   			
 	   	<%@include file="include/footer.jsp" %>
</body>
</html>