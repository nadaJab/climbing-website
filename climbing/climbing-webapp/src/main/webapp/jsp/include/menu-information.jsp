<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<body>

	<%@include file="menu.jsp"%>

	<div class="container">

		<div class="row justify-content-lg-center">
			<div class="col-sm-6">

				<ul class="nav nav-tabs">
					<li class="nav-item"><s:a action="siteDetail"
							class="nav-link active">
							<s:param name="idSpot" value="idSpot" />Informations</s:a></li>

					<li class="nav-item"><s:a action="secteurInformation"
							class="nav-link">
							<s:param name="idSpot" value="idSpot" />Secteurs et Voies</s:a></li>

					<li class="nav-item"><a class="nav-link" href="#">Topo</a></li>
				</ul>
			</div>

		</div>
	</div>

</body>
</html>
