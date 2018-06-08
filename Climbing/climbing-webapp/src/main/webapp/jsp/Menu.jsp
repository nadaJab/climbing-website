<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
	<sj:head jqueryui="true"/>
  </head>
  
  <body>
	<sj:menu id="menuWithItems" class="navbar navbar-expand-lg navbar-light bg-light">
	
	<sj:menuItem title="Accueil" href="jsp/Home/"/>
	<sj:menuItem title="Site">
		<sj:menu id="subMenuPlugins" cssStyle="width:50%">
			<sj:menuItem title="Localiser un site" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
			<sj:menuItem title="Ajouter un site" href="https://github.com/struts-community-plugins/struts2-jquery/"/>
		</sj:menu>
	</sj:menuItem>

	<sj:menuItem title="Topo">
		<sj:menu id="subMenuSocialMedia" cssStyle="width:50%">
			<sj:menuItem title="Liste topo" href="https://twitter.com/TheApacheStruts"/>
			<sj:menuItem title="Ajouter un topo" href="https://www.google.com/+ApacheStruts"/>
		</sj:menu>
	</sj:menuItem>
	
	<sj:menuItem title="Connexion">
		<sj:menu id="subMenuSocialMedia" cssStyle="width:50%">
			<sj:menuItem title="Connexion" href="https://twitter.com/TheApacheStruts"/>
			<sj:menuItem title="Créer un compte" href="https://www.google.com/+ApacheStruts"/>
		</sj:menu>
	</sj:menuItem>

	</sj:menu>
  </body>
</html>