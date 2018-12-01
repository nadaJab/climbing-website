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
		<div class="row justify-content-lg-center">
			<div class="col-sm-6">
				<!-- 
				<ul class="nav nav-tabs">
					<li class="nav-item"><s:a action="siteDetail"
							class="nav-link active">
							<s:param name="idSpot" value="idSpot" />Informations</s:a></li>

					<li class="nav-item"><s:a action="secteurInformation"
							class="nav-link">
							<s:param name="idSpot" value="idSpot" />Secteurs et Voies</s:a></li>

					<li class="nav-item"><a class="nav-link"
						href="#collapseExample">Topo</a></li>
				</ul> -->

				<ul class="nav nav-tabs" id="myTab" role="tablist">
				
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">Informations</a></li>
						
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">Secteurs et Voies</a></li>
						
					<li class="nav-item"><a class="nav-link" id="contact-tab"
						data-toggle="tab" href="#contact" role="tab"
						aria-controls="contact" aria-selected="false">Topo</a></li>
				</ul>
			</div>
		</div>
		
		<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">aaa</div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">bb</div>
  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">cc</div>
</div>
	</div>

	<div class="container">

		<div class="card">
			<div class="card-header">Secteurs et voies</div>
			<div class="card-body">
				<div class="card">
					<div class="card-body">
						<s:submit value="Voir détails"
							cssClass="btn btn-primary btn-sm left-block" />
					</div>
				</div>
			</div>
		</div>

		<s:a action="ajoutsecteur">
			<s:param name="idSpot" value="idSpot" />
			<button type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-plus"></span>
			</button>
		</s:a>
	</div>

</body>
</html>