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
 	<form class="form-inline" role="form" name="form" action="" method="post">
 		  <div class="form-row">
 	
 	 <div class="form-group col-md-6">
      <label for="inputCity">Ville</label>
       <input type="text" class="form-control" id="inputCity">
    </div>
 		  
    <div class="form-group col-md-6">
      <label for="inputState">Pays</label>
      <input type="text" class="form-control" id="inputState">
    </div>
    
    <div class="form-group col-md-6">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
 	</div>
 	
  </div>
 	
 	    	
 	</form>
 	</div>     	
          
</body>
</html>