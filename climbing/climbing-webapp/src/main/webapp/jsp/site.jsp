
<%@include file="include/menu.jsp"%>

<div class="container">
	<div class="row justify-content-lg-center">
		<div class="col-sm-6">

			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<li class="nav-item"><s:a action="siteDetail"
						class="nav-link active" id="siteDetail-tab" data-toggle="tab"
						href="#siteDetail" role="tab" aria-controls="siteDetail"
						aria-selected="false">
						<s:hidden key="idSpot" />Informations</s:a></li>

				<li class="nav-item"><s:a action="sectorDetail"
						class="nav-link" id="sectorDetail-tab" data-toggle="tab"
						href="#sectorDetail" role="tab" aria-controls="sectorDetail"
						aria-selected="false">
						<s:hidden key="idSpot" />Secteurs et Voies</s:a></li>

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
		<div class="tab-pane fade show active" id="siteDetail" role="tabpanel"
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
			<br/>

			<div class="card">
				<div class="card-body">
					<h5>Commentaire</h5>
					<s:if test="comment.empty">
						<div class="row justify-content-lg-center">
							<p class="text-center grossissement">Aucun commentaire ajouté</p>
						</div>
					</s:if>

					<s:else>
						<s:iterator value="comment">
							<div class="list">
								<div class="card">
									<div class="card-body">

										<s:property value="user.pseudo" />
										:
										<s:property value="content" />
										<s:property value="dateComment" />
										.
										<s:if test="#session.user.role == 'admin'">
											<s:a action="deleteCommentSpot" class="btn btn-outline-danger">
												<span class="fas fa-trash-alt"></span>

												<s:hidden key="idSpot" />
												<s:param name="idSpot" value="idSpot" />
												<s:hidden key="idComment" />
												<s:param name="idComment" value="idComment" />
											</s:a>
										</s:if>

									</div>

								</div>
							</div>
						</s:iterator>
					</s:else>
					<!--  		<s:property value="comment" />-->

					<s:form action="ajoutCommentaire" validate="true" theme="bootstrap"
						cssClass="form-horizontal">
						<s:textfield key="commentBean.content"
							placeholder="Votre commentaire...." />
						<s:hidden key="idSpot" />
						<s:hidden key="#session.user.idUser"></s:hidden>

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
							<div class="list">
								<div class="card">
									<div class="card-body">

										<h5>
											Nom du secteur:
											<s:property value="sectorName" />
										</h5>

										<div class="card">
											<div class="card-body">
												<s:hidden key="idSector" />

												<ul id="lignes">
													<table class="table">
														<thead>
															<tr class="table-primary">
																<th scope="col">Nom</th>
																<th scope="col">Cotation</th>
																<th scope="col">Hauteur</th>
																<th scope="col">Nombre des points</th>
																<th scope="col">Ouvreur</th>
																<th scope="col">Année d'ouverture</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="lignes">

																<!--  
																<s:if test="#session.user.role == 'admin'">
																	<s:a action="deleteSpot" class="btn btn-outline-danger">
																		<span class="fas fa-times"></span>
																		<s:hidden key="idSpot" />
																		<s:param name="idSpot" value="idSpot" />
																	</s:a>
																</s:if>
														-->
															</s:iterator>

														</tbody>
													</table>
												</ul>

												<button type="button" class="btn btn-info voieId">Voir</button>
											</div>
										</div>

										<!-- Ajout ligne -->
										<s:a action="ajoutligne" class="btn btn-primary">
											<s:param name="idSector" value="idSector" />
											<span class="fas fa-plus"></span>
										</s:a>

										<!-- Supprimer le secteur par l'admin -->
										<s:if test="#session.user.role == 'admin'">
											<s:a action="deleteSector" class="btn btn-outline-danger">
												<span class="fas fa-trash-alt"></span>
												<s:hidden key="idSector" />
												<s:param name="idSector" value="idSector" />
											</s:a>
										</s:if>
									</div>
								</div>
								<br/>
							</div>
						</s:iterator>
					</s:else>
				</div>
				<!-- Action pour ajouter un secteur -->
			</div>
			<s:a action="ajoutsecteurOk" class="btn btn-primary">
				<s:hidden key="idSpot" />
				<s:param name="idSpot" value="idSpot" />
				<span class="fas fa-plus"></span>
			</s:a>
		</div>

		<!-- Topo -->
		<div class="tab-pane fade" id="contact" role="tabpanel"
			aria-labelledby="contact-tab">
			<div class="card">
				<div class="card-header">Topo</div>
				<div class="card-body">

					<s:if test="topos.empty">
						<div class="row justify-content-lg-center">
							<p class="text-center grossissement">Aucun topo qui existe
								pour ce site</p>
						</div>
					</s:if>

					<s:else>
						<s:iterator value="topos">
							<div class="card" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">
										<s:property value="topoName" />
									</h5>
									<s:a action="topoDetails" class="btn btn-primary"><span
										class="fas fa-file-image"></span><s:hidden key="idTopo" /><s:param name="idTopo" value="idTopo" />
										 Voir topo</s:a>
								</div>
							</div>
							<br/>
						</s:iterator>
					</s:else>
				</div>
			</div>
			<!-- Action pour ajouter un nouveau topo -->
			<s:a action="ajouttopo" class="btn btn-primary">
				<s:param name="idSpot" value="idSpot" />
				<span class="fas fa-plus"></span>
			</s:a>
		</div>

	</div>
</div>


<%@include file="include/footer.jsp"%>

<script>
	$()
			.ready(
					function() {

						$(".voieId")
								.click(
										function(event) {

											const idSector = $(this).parent()
													.children("#idSector")
													.val();
											console.log("mon idSector egale "
													+ idSector);

											// URL de l'action AJAX
											var url = "<s:url action="ajax_getListLignes"/>";

											var $lignes = $(this).parent()
													.children("#lignes")
													.children("table")
													.children("tbody");

											// Action AJAX en POST
											jQuery
													.post(
															url,
															{
																idSector : idSector
															},

															function(data) {

																console
																		.log("data: "
																				+ data.responseJSON);
																console
																		.log("idSector: "
																				+ idSector);

																$lignes.empty();
																jQuery
																		.each(
																				data,
																				function(
																						key,
																						val) {
																					var html = "";

																					html += '<tr>';
																					html += ("<td>"
																							+ val.routeName + "</td>");
																					html += ("<td>"
																							+ val.cotation + "</td>");
																					html += ("<td>"
																							+ val.height + "</td>");
																					html += ("<td>"
																							+ val.pointNumber + "</td>");

																					if (val.routeOpener == "") {
																						html += ("<td> non renseigné </td>");
																					} else {
																						html += ("<td>"
																								+ val.routeOpener + "</td>");
																					}

																					if (val.openingYear == 0) {
																						html += ("<td> non renseigné </td>");
																					} else {
																						html += ("<td>"
																								+ val.openingYear + "</td>");
																					}
																					html += '</tr>';

																					$lignes
																							.append(html);

																					console
																							.log("val: "
																									+ val.cotation);
																					console
																							.log("val: "
																									+ val.routeName);

																				});

															})
													.fail(
															function() {
																alert("Une erreur s'est produite.");
															});

										});
					});
</script>
</body>
</html>