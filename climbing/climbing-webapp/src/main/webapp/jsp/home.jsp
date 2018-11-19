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
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
	<%@include file="include/menu.jsp"%>
	<s:actionerror />
	<s:fielderror />
		
	<div class="container">
		<!-- recherche multi-critères  -->
		<div class="row">
			<div class="col-sm-24 col-xs-12">
				<!--  Niveau 1 -->

				<div class="row">
					<div class="col-sm-10 col-xs-4 col-sm-offset-1 col-xs-offset-1">

						<!--  Niveau 2 -->
						<div class="col-sm-24 hidden-xs">
							<s:form action="search" theme="simple" cssClass="well form-search">
								<s:textfield key="spotBean.spotName" placeholder="Le nom du site" />
								<s:textfield key="countryBean.cityName" placeholder="Ville" />
								<s:textfield key="countryBean.countryName" placeholder="Pays" />
								<s:submit cssClass="btn btn-primary" key="search" />
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- slider -->
		
</div>

	</div>

	<%@include file="include/footer.jsp"%>
</body>
</html>