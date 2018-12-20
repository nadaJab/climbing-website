
<%@include file="include/menu.jsp"%>
<s:actionerror />
<s:fielderror />

<div class="container">
	<hr class="mb-4">

	<!-- recherche multi-critères  -->
	<div class="card">
		<div class="card-body">
			<s:form action="search" theme="simple" cssClass="well form-search">
				<s:textfield key="spotBean.spotName" placeholder="Le nom du site" />
				<s:textfield key="countryBean.cityName" placeholder="Ville" />
				<s:textfield key="countryBean.countryName" placeholder="Pays" />

				<s:submit cssClass="btn btn-primary" key="search" />
			</s:form>
		</div>
	</div>
</div>

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
				<hr class="mb-4">

			</s:iterator>
		</s:else>
	</div>
</s:if>

<%@include file="include/footer.jsp"%>
</body>
</html>