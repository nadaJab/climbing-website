<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/Tarek/view/visitor/home/bootstrap-4.1.2/js/dropdown.js" media="screen"/>

	<sj:head jqueryui="true" />
	<sb:head includeScripts="true" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>

<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="navbar-header">
				<a class="navbar-brand" href="home.action"><span class="fas fa-hiking"></span>Home</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="nav navbar-nav">
					
					<!-- dropdown site -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Site<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Localiser un site</a></li>							
							<li><s:a action="ajoutsite">Ajouter un site</s:a></li>
						</ul></li>

					<!-- dropdown Topo -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Topo<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Liste topo</a></li>
							<li><s:a action="ajouttopo.action">Ajouter un topo</s:a></li>
						</ul>
					</li>

					 <ul class="nav navbar-nav navbar-right">
					 
					 	 <s:if test="#session.user">
      					 	<li><s:a><s:property value="#session.user.pseudo" /><span class="glyphicon glyphicon-user"></span></s:a></li>
	            			<li><s:a action="deconnexion.action">Déconnexion</s:a></li>
      					 </s:if>
      					 
      					 <s:else>
      					<li><s:a action="connexion.action"><span class="glyphicon glyphicon-user"></span>Connexion</s:a></li>
      					<li><s:a action="inscription.action"><span class="glyphicon glyphicon-log-in"></span>Inscription</s:a></li>
      					</s:else>
      					
    				</ul>
				
				<!--  
					<div class="btn btn-default">
  						<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  							<span class="fas fa-hiking fa-2x"></span>
  						</button>
  					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    					<a class="dropdown-item" href="#">Déconnexion</a>
    					<a class="dropdown-item" href="#">Topo</a>
  					</div>
					</div>					
					-->
				</ul>


			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>
</body>
</html>
