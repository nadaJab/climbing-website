<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/Tarek/view/visitor/home/bootstrap-4.1.3/js/dropdown.js"
	media="screen" />

<sj:head jqueryui="true" />
<sb:head includeScripts="true" />

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

</head>
<body>

	<header>
		<nav class="navbar navbar-default">

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<a class="navbar-brand" href="home.action"><span
					class="fas fa-hiking"></span>Home</a>
					
				<ul class="nav navbar-nav">
				
					<!-- dropdown site -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Site </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Localiser un site</a>
							<s:a action="ajoutsite" class="dropdown-item">Ajouter un site</s:a>
						</div></li>

					<!-- dropdown Topo -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Topo </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Liste topo</a>
							<s:a action="ajouttopo.action" class="dropdown-item">Ajouter un topo</s:a>
						</div></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<s:if test="#session.user">
						<li><s:a>
								<s:property value="#session.user.pseudo" />
								<span class="glyphicon glyphicon-user"></span>
							</s:a></li>
						<li><s:a action="deconnexion.action">Déconnexion</s:a></li>
					</s:if>

					<s:else>
						<li><s:a action="connexion.action">
								<span class="glyphicon glyphicon-user"></span>Connexion</s:a></li>
						<li><s:a action="inscription.action">
								<span class="glyphicon glyphicon-log-in"></span>Inscription</s:a></li>
					</s:else>

				</ul>
			</div>
		</nav>
	</header>
</body>
</html>
