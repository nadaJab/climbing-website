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
			<h3>COUCOU</h3>
			<p class="lieu">Pays: <s:property value="spot.spotName"/></p>
			
			
			
		</div></div></div></div></div>
	</div>
</body>
</html>