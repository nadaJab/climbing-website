<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<sj:head jqueryui="true" />
	<sb:head includeScripts="true" />
</head>

<body>
	<%@include file="include/menu.jsp"%>
	
	<div class="container">
		<div class="row">
		<div class="col-sm-24 col-xs-12">
		<div class="row">
		<div class="col-sm-10 col-xs-4 col-sm-offset-1 col-xs-offset-1">
		<div class="col-sm-24 hidden-xs">
<ul class="nav nav-tabs">
 
 	<div class="btn-group" role="group" aria-label="Basic example">
  		<button type="button" class="btn btn-success">Informations</button>
  		<button type="button" class="btn btn-success">Secteurs et Voies</button>
  		<button type="button" class="btn btn-success">Topo</button>
	</div>
 
</ul>
			<h3>Informations sur <s:property value="spotBean.spotName" /></h3>
			<h4><p>
				<s:property value="spotBean.spotName" /> est un site d'escalade de <s:property value="spotBean.climbingType" />, 
				situé à Mont-Dol dans le département Ille-et-Vilaine (fr) 
			   	On y trouve <s:property value="spotBean.nbRoutesTotal" /> lignes allant de <s:property value="spotBean.cotationMin" />
			   	à <s:property value="spotBean.cotationMax" />.</br>
			   	Orientation du site:  <s:property value="spotBean.orientation" />
			   	
			</p></h4> 
			
			
		</div></div></div></div></div>
	</div>
</body>
</html>