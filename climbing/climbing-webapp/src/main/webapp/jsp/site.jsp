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
 
	<div class="container content">
		<s:if test="listSpot.empty">
			<div class="row justify-content-lg-center">
			<p class="text-center grossissement">Aucun site n'a été trouvé</p>
			</div>
		</s:if>
		<s:else>
			<div class="row justify-content-lg-center">
			
			<s:if test="isTestVar()">
			 		<div class="col-sm-24 col-xs-12">
						<div class="panel panel-default">
						<div class="panel-heading"></div> 
							<div class="panel-body">
							 
							<pre><p> 
							Nom du site: <s:property value="spotBean.spotName"/>
							Ville: <s:property value="spotBean.country.cityName"/>  
							Pays:<s:property value="spotBean.country.countryName"/>
							</p></pre>
							<s:a action="topo_detail"><s:param name="id" value="id" /><button class="btn btn-success">Voir détails</button></s:a>
			 		</div></div></div>
			</s:if>
			
			<s:else> 
			<s:iterator value="listSpot">
					<div class="list">
					<div class="col-sm-24 col-xs-12">
						<div class="panel panel-default">
						<div class="panel-heading"></div> 
							<div class="panel-body">
							 
							<pre><p> 
							Nom du site: <s:property value="spotName"/>
							Ville: <s:property value="country.cityName"/>  
							Pays:<s:property value="country.countryName"/>
							</p></pre>

							<s:a action="siteDetail"><s:param name="idSpot" value="idSpot" /><button class="btn btn-success">Voir détails</button></s:a>
						</div>
						</div>
					</div>
					</div>
			</s:iterator>
			</s:else>
			</div>
		</s:else>
	</div>
	
</body>
</html>