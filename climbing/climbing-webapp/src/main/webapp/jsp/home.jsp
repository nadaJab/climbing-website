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
    <!-- recherche multi-critères  -->
 	<div class="row">
    <div class="col-sm-24 col-xs-12">
      <!--  Niveau 1 --> 
      
        <div class="row">
        <div class="col-sm-10 col-xs-4 col-sm-offset-1 col-xs-offset-1">
            
             <!--  Niveau 2 --> 
 				<div class="col-sm-24 hidden-xs">                
                <s:form theme="simple" cssClass="well form-search" >
                	<s:textfield key="nameSpot" placeholder="Le nom du site"/>
    				<s:textfield key="city" placeholder="Ville"/>
    				<s:password key="state" placeholder="Pays"/>
    				<s:submit cssClass="btn btn-primary" key="search"/>
				</s:form>
                </div>
        </div>   
        </div>
    </div>
</div>

</div>  	    	
 	    	
 	   	<%@include file="include/footer.jsp" %>
</body>
</html>