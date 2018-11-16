<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<header>

	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="navbar-header">
				<a class="navbar-brand" href="home.action">Home</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

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
						</ul></li>

					<!-- dropdown connexion -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Connexion<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><s:a action="connexion.action">Connexion</s:a></li>
							<li><s:a action="inscription.action">Inscription</s:a></li>
						</ul>
					</li>
					
				<!--  
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="fas fa-hiking fa-2x"></span></a>
						<ul class="dropdown-menu">
							<li><s:a action="connexion.action">Déconnexion</s:a></li>
							<li><s:a action="inscription.action">Topo</s:a></li>
						</ul>
					</li> -->
					
					<div class="btn btn-default">
  						<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  							<span class="fas fa-hiking fa-2x"></span>
  						</button>
  					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    					<a class="dropdown-item" href="#">Déconnexion</a>
    					<a class="dropdown-item" href="#">Topo</a>
  					</div>
					</div>					
					<!-- 
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Person <span class="oi" data-glyph="person"></span> </a>
						<ul class="dropdown-menu">
							<li><a href="connexion.action">Connexion</a></li>
						</ul>
					</li>
  					 -->
				</ul>


			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

</header>