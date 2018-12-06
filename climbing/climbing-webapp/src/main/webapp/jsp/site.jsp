
<%@include file="include/menu.jsp"%>

<div class="container">
	<div class="row justify-content-lg-center">
		<div class="col-sm-6">

			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<li class="nav-item"><s:a action="siteDetail"
						class="nav-link active" id="siteDetail-tab" data-toggle="tab"
						href="#siteDetail" role="tab" aria-controls="siteDetail"
						aria-selected="true">
						<s:param name="idSpot" value="idSpot" />Informations</s:a></li>

				<li class="nav-item"><s:a action="sectorDetail"
						class="nav-link" id="sectorDetail-tab" data-toggle="tab"
						href="#sectorDetail" role="tab" aria-controls="sectorDetail"
						aria-selected="false">
						<s:param name="idSpot" value="idSpot" />Secteurs et
							Voies</s:a></li>

				<li class="nav-item"><a class="nav-link" id="contact-tab"
					data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">Topo</a></li>
			</ul>

		</div>
	</div>
</div>

<div class="container">
	<div class="tab-content" id="myTabContent">

		<!-- Information -->
		<div class="tab-pane fade" id="siteDetail" role="tabpanel"
			aria-labelledby="siteDetail-tab">
			<s:a action="siteDetail"></s:a>
			<div class="card">
				<div class="card-header">
					Informations sur
					<s:property value="spotBean.spotName" />
				</div>

				<div class="card-body">

					<div class="row">
						<div class="col-sm">
							<h4>
								<span class="fas fa-map-marker-alt"></span>Emplacement:
							</h4>
							<s:property value="spotBean.country.cityName" />
							en
							<s:property value="spotBean.country.countryName" />
						</div>

						<div class="col-sm">
							<h4>
								<span class="fas fa-info-circle"></span>Type d'escalade:
							</h4>
							<s:property value="spotBean.climbingType" />
						</div>

						<div class="col-sm">
							<h4>
								<span class="fas fa-map-signs"></span>Orientation:
							</h4>
							<s:property value="spotBean.orientation" />
						</div>
					</div>

					<div class="row">
						<div class="col-sm">
							<h4>
								<span class="fas fa-chart-line"></span>Nombre de voies:
							</h4>
							<s:property value="spotBean.nbRoutesTotal" />
						</div>

						<div class="col-sm">
							<h4>
								<span class="fas fa-stream"></span>Cotation:
							</h4>
							cotation minimale:
							<s:property value="spotBean.cotationMin" />
							</br> cotation maximale:
							<s:property value="spotBean.cotationMax" />
						</div>

						<div class="col-sm"></div>
					</div>

				</div>
			</div>
 
			<div class="card">
				<div class="card-body">
					<s:form action="ajoutCommentaire" validate="true" theme="bootstrap" cssClass="form-horizontal" label="Commentaire">
					<s:textfield key="commentSpotBean.content"
						placeholder="Votre commentaire...." />
						
					<s:param name="idSpot" value="idSpot" />
					<s:date name="customDate" />
					<s:submit value="Ajouter"
						cssClass="btn btn-primary btn-sm center-block" />
					</s:form>	
				</div>
			</div> 
		</div>

		<!-- Secteurs et voies -->
		<div class="tab-pane fade" id="sectorDetail" role="tabpanel"
			aria-labelledby="sectorDetail-tab">
			<div class="card">
				<div class="card-header">Secteurs et voies</div>
				<div class="card-body">
					<s:if test="sectors.empty">
						<div class="row justify-content-lg-center">
							<p class="text-center grossissement">Aucun secteur n'a été
								trouvé</p>
						</div>
					</s:if>

					<s:else>
						<s:iterator value="sectors">
							<div class="card">
								<div class="card-body">

									<h5>
										Nom du secteur:
										<s:property value="sectorName" />
									</h5>

									<div class="accordion" id="accordionExample">

										<div class="card">
											<div class="card-header" id="headingThree">
												<h5 class="mb-0">
													<s:a action="listLigne" class="btn btn-link collapsed"
														data-toggle="collapse" data-target="#collapseThree"
														aria-expanded="false" aria-controls="collapseThree">
														<s:hidden key="idSector" />Lignes</s:a>
												</h5>
											</div>
											<div id="collapseThree" class="collapse"
												aria-labelledby="headingThree"
												data-parent="#accordionExample">
												<div class="card-body">
													<s:if test="lignes.empty">
														<div class="row justify-content-lg-center">
															<p class="text-center grossissement">Aucune ligne n'a
																été trouvée</p>
														</div>
													</s:if>
													<s:else>
														<s:iterator value="lignes">
															<s:property />
														</s:iterator>
													</s:else>
												</div>
											</div>
										</div>
									</div>

									<!-- Ajout ligne -->
									<s:a action="ajoutligne" class="btn btn-default">
										<s:param name="idSector" value="idSector" />
										<span class="glyphicon glyphicon-plus"></span>
									</s:a>
								</div>
							</div>
						</s:iterator>
					</s:else>
				</div>

			</div>
			<s:a action="ajoutsecteur" class="btn btn-primary">
				<s:param name="idSpot" value="idSpot" />
				<span class="glyphicon glyphicon-plus"></span>
			</s:a>
		</div>

		<!-- Topo -->
		<div class="tab-pane fade" id="contact" role="tabpanel"
			aria-labelledby="contact-tab">
			<div class="card">
				<div class="card-header">Topo</div>
				<div class="card-body">
					<div class="card">
						<div class="card-body"></div>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>
</body>
</html>