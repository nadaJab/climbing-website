
<%@include file="include/menu.jsp"%>
<s:actionerror />
<s:fielderror />

<div class="container">
	<br/>
	
	<!-- recherche multi-critères  -->

			<s:form action="search" theme="simple" class="btn-lg">

				<s:textfield key="spotBean.spotName" placeholder="Le nom du site" />
				<s:textfield key="countryBean.cityName" placeholder="Ville" />
				<s:textfield key="countryBean.countryName" placeholder="Pays" />
			
				<s:submit cssClass="btn btn-primary btn-lg" key="search" />	
			</s:form>

<s:if test="!isTestAffichage()">	
	<br/>
	<div id="carouselExampleControls" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="/climbing-webapp/assets/images-topo/Image-home/photo11.jpg"
					alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Bienvenu à notre site</h5>
					<p>Site communautaire dédié à l'escalade</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/climbing-webapp/assets/images-topo/Image-home/photo12.jpg"
					alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Bienvenu à notre site</h5>
					<p>Site communautaire dédié à l'escalade</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/climbing-webapp/assets/images-topo/Image-home/photo13.jpg"
					alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Bienvenu à notre site</h5>
					<p>Site communautaire dédié à l'escalade</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleControls"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</s:if>
	
</div>

<br/>
<!-- Résultat de recherche -->
<s:if test="isTestAffichage()">
	<div class="container content">
		<s:if test="listSpot.empty">
			<div class="row justify-content-lg-center">
				<p class="text-center grossissement">Aucun site n'a été trouvé</p>
			</div>
		</s:if>

		<s:else>
			<s:iterator value="listSpot">
				<div class="list">
					<div class="card">
						<div class="card-header"></div>
						<div class="card-body">
							<h5 class="card-title">
								Nom du site:
								<s:property value="spotName" />
							</h5>
							<h5 class="card-title">
								Ville:
								<s:property value="country.cityName" />
							</h5>
							<h5 class="card-title">
								Pays:
								<s:property value="country.countryName" />
							</h5>

							<s:a action="siteDetail" class="btn btn-primary">
								<s:param name="idSpot" value="idSpot" />Voir détails</s:a>

							<s:if test="#session.user.role == 'admin'">
								<s:a action="deleteSpot" class="btn btn-outline-danger">
									<span class="fas fa-trash-alt"></span>
									<s:hidden key="idSpot" />
									<s:param name="idSpot" value="idSpot" />
								</s:a>
							</s:if>

						</div>
					</div>
				</div>
				<br/>
			</s:iterator>
		</s:else>
	</div>
</s:if>
<%@include file="include/footer.jsp"%>
</body>
</html>