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

		<s:form action="ajoutsecteurOk" enctype="multipart/form-data"
			cssClass="form-horizontal" label="Ajouter un nouveau secteur">
			<s:hidden key="idSpot"></s:hidden>
			
			<s:textfield key="sectorBean.sectorName" />
			<s:submit value="Ajouter" cssClass="btn btn-primary center-block" />
		</s:form>
	</div>
	<%@include file="include/footer.jsp"%>

</body>
</html>