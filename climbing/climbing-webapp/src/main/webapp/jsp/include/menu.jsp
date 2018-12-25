<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>


<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
	
	<!--  
    <script src="https://unpkg.com/gijgo@1.9.11/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.11/css/gijgo.min.css" rel="stylesheet" type="text/css" />  -->
    
    <sx:head />
</head>
<body background="/climbing-webapp/images/Image-home/Background1.jpg">

	<header>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="home.action"> <span class="fas fa-hiking"></span>Home
					</a></li>
					
					<!-- dropdown site -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Site </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Localiser un site</a> 
							<s:a action="ajoutsite" class="dropdown-item">Ajouter un site</s:a> 
							
						</div></li>
						
					<!-- dropdown Topo -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Topo </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Liste topo</a> 
						</div></li>
						
				</ul>
				<ul class="navbar-nav ml-auto">
					<s:if test="#session.user">
						<li class="nav-item active"><s:a class="nav-link" action="userProfile">
							<s:property value="#session.user.pseudo" />
								<span class="fas fa-user"></span>
							</s:a></li>
						<li class="nav-item active"><s:a class="nav-link" action="deconnexion.action">Déconnexion
							<span class="fas fa-user-times"></span>
						</s:a></li>	
					</s:if>

					<s:else>
						<li class="nav-item active"><s:a class="nav-link" action="connexion.action">
								<span class="fas fa-user"></span>Connexion</s:a></li>
						<li class="nav-item active"><s:a class="nav-link" action="inscription.action">
								<span class="fas fa-sign-in-alt"></span>Inscription</s:a></li>
					</s:else>

				</ul>
			</div>
		</nav>

	</header>