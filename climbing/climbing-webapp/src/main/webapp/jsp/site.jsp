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
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="#">Informations</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Secteurs et Voies</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Topo</a></li>
				</ul> -->
				
				<ul class="nav nav-tabs" id="myTab" role="tablist">

					<li class="nav-item"><s:a action="siteDetail" class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true"><s:param name="idSpot" value="idSpot" />Informations</s:a></li>

					<li class="nav-item"><s:a action="sectorDetail"
							class="nav-link" id="profile-tab" data-toggle="tab"
							href="#profile" role="tab" aria-controls="profile"
							aria-selected="false"><s:param name="idSpot" value="idSpot" />Secteurs et
							Voies</s:a></li>

					<li class="nav-item"><a class="nav-link" id="contact-tab"
						data-toggle="tab" href="#contact" role="tab"
						aria-controls="contact" aria-selected="false">Topo</a></li>
				</ul> 

			</div>
		</div>
	</div>

	<div class="container">
		<div class="tab-content" id="myTabContent">

			<!-- Information -->
			<div class="tab-pane fade show active" id="home" role="tabpanel"
				aria-labelledby="home-tab">
				<s:a action="siteDetail"></s:a>
				<div class="card">
					<div class="card-header">
						Informations sur
						<s:property value="spotBean.spotName" />
					</div>

					<div class="card-body">

						<div class="row">
							<div class="col-sm">
								<h4>
									<span class="fas fa-map-marker-alt"></span>Emplacement:
								</h4>
								<s:property value="spotBean.country.cityName" />
								en
								<s:property value="spotBean.country.countryName" />
							</div>

							<div class="col-sm">
								<h4>
									<span class="fas fa-info-circle"></span>Type d'escalade:
								</h4>
								<s:property value="spotBean.climbingType" />
							</div>

							<div class="col-sm">
								<h4>
									<span class="fas fa-map-signs"></span>Orientation:
								</h4>
								<s:property value="spotBean.orientation" />
							</div>
						</div>

						<div class="row">
							<div class="col-sm">
								<h4>
									<span class="fas fa-chart-line"></span>Nombre de voies:
								</h4>
								<s:property value="spotBean.nbRoutesTotal" />
							</div>

							<div class="col-sm">
								<h4>
									<span class="fas fa-stream"></span>Cotation:
								</h4>
								cotation minimale:
								<s:property value="spotBean.cotationMin" />
								</br> cotation maximale:
								<s:property value="spotBean.cotationMax" />
							</div>

							<div class="col-sm"></div>
						</div>

						<div class="card">
							<div class="card-body">
								<s:textfield placeholder="Votre commentaire...." />
								<s:submit value="Ajouter"
									cssClass="btn btn-primary btn-sm left-block" />
							</div>
						</div>

					</div>
				</div>
			</div>

			<!-- Secteurs et voies -->
			<div class="tab-pane fade" id="profile" role="tabpanel"
				aria-labelledby="profile-tab">
				<!-- *** -->
				<div class="card">
					<div class="card-header">Secteurs et voies</div>
					<div class="card-body">
						<s:if test="sectors.empty">
							<div class="row justify-content-lg-center">
								<p class="text-center grossissement">Aucun secteur n'a été
									trouvé</p>
							</div>
						</s:if>

						<s:else>
							<s:iterator value="sectors">
								<div class="card">
									<div class="card-body">

										<h5>
											Nom su secteur:
											<s:property value="sectorName" />
										</h5>

										<p>
											<s:a action="" class="btn btn-primary" data-toggle="collapse"
												href="#collapseExample" role="button" aria-expanded="false"
												aria-controls="collapseExample"> Lignes </s:a>
										</p>
										<div class="collapse" id="collapseExample">
											<div class="card card-body">coucou</div>
										</div>
									</div>
								</div>
							</s:iterator>
						</s:else>
					</div>

				</div>
				<s:a action="ajoutsecteur" class="btn btn-primary">
						<s:param name="idSpot" value="idSpot" />
						<span class="glyphicon glyphicon-plus"></span>
				</s:a>				
			</div>

			<!-- Topo -->
			<div class="tab-pane fade" id="contact" role="tabpanel"
				aria-labelledby="contact-tab">
				<div class="card">
					<div class="card-header">Topo</div>
					<div class="card-body">
						<div class="card">
							<div class="card-body"></div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</body>
</html>