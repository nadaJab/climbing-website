# Climbing-website

Créez un site communautaire autour de l’escalade

# Technologies:
* JDK8 version 191
* Apache Maven 3.5.4
* Apache Tomcat 9.0.12
* PostgreSQL 9.6

# Installation des outils:
  Configuration de la base de données:
* Installation de PostgreSQL
* Ouvrir le fichier : climbing-webapp/src/main/webapp/META-INF/context.xml et paramètrer la base de données avec la mème configuration
	url="jdbc:postgresql://localhost:5432/climbing-bdd"
	driverClassName="org.postgresql.Driver"
	username="admin123"
	password="projet6" 
	defaultAutoCommit="false"
	defaultTransactionIsolation="READ_COMMITTED" 
	initialSize="1"
* Lancez les script sql qui se trouvent dans le dossier Documentation/script:
* 1- Dossier user: --> Lancer le script account_0.0.1.sql ensuite user_0.0.1.sql 	
* 2- Dossier user-admin: --> Lancer le script account_admin.sql ensuite user_Admin.sql
* 3- Dossier site-Mont-Dol: --> lancer les script country.sql --> spot.sql --> sector.sql --> spot-sector.sql --> route.sql --> sector-route.sql --> topo.sql
* Chemin à modifier --> dans le module climbing-webapp --> src/main/resources/org/climbing/action --> file.properties (uploads.saveDir)
* déploiement du projet :

-Avec IDE:
Téléchargez le projet depuis Github à l’url https://github.com/nadaJab/climbing-website
Ensuite, dézippez le projet qui contient deux dossiers : Documentation et climbing
Dans votre IDE,--> importez le dossier climbing --> clique droit sur le projet --> Run as --> Maven build --> clean packages
Enfin, lancez le module climbing-webapp sur le serveur 
Et entrez sur votre navigateur l'URL: http://localhost:8080/climbing-webapp/home.action 
		
-Sans IDE:
Dans le dossier Documentation, vous trouvez le fichier climbing-webapp.war. Copiez ce fichier dans le repertoire Tomcat/webapps
Demarrez Tomcat et lancez l'URL: http://localhost:8080/climbing-webapp/home.action  

