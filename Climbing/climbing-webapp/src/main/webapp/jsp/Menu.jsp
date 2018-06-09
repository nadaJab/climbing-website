<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
            
  <!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">          

<nav class="navbar navbar-default">
<div class="container-fluid">

	<div class="navbar-header">
  		<a class="navbar-brand" href="#">Accueil</a>
	</div>  

    <!-- Left nav -->
    <ul class="nav navbar-nav mr-auto">
     
      				
      <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#">Site</a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="jsp/Home/">Localiser un site</a></li>
          <li><a class="dropdown-item disabled" href="jsp/Home/">Ajouter un site</a></li>
        </ul>
      </li>
      
      <li class="nav-item dropdown">

      <a class="nav-link dropdown-toggle" href="#">Topo</a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Liste topo</a></li>
          <li><a class="dropdown-item disabled" href="#">Ajouter un topo</a></li>
        </ul>
      </li>
   
    
    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#">Connexion</a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Connexion</a></li>
          <li><a class="dropdown-item disabled" href="#">Créer un compte</a></li>
        </ul>
      </li>
    </ul>

	<form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
    </form>
    
  </div>
</nav>
