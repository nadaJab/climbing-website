
	<%@include file="include/menu.jsp"%>
	<s:actionerror />
	<s:fielderror />
	
	<div class="container">
		<!-- recherche multi-critères  -->
		<div class="row">
			<div class="col-sm-24 col-xs-12">
				<!--  Niveau 1 -->

				<div class="row">
					<div class="col-sm-10 col-xs-4 col-sm-offset-1 col-xs-offset-1">

						<!--  Niveau 2 -->
						<div class="col-sm-24 hidden-xs">
							<s:form action="search" theme="simple"
								cssClass="well form-search">
								<s:textfield key="spotBean.spotName"
									placeholder="Le nom du site" />
								<s:textfield key="countryBean.cityName" placeholder="Ville" />
								<s:textfield key="countryBean.countryName" placeholder="Pays" />

								<s:submit cssClass="btn btn-primary" key="search" />
							</s:form>
						</div>
					</div>
				</div>
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
										<h5 class="card-title">Nom du site: <s:property value="spotName"/></h5>
										<h5 class="card-title">Ville: <s:property value="country.cityName"/></h5>
										<h5 class="card-title">Pays:<s:property value="country.countryName"/></h5>
										
										<s:a action="siteDetail" class="btn btn-primary"><s:param name="idSpot" value="idSpot" />Voir détails</s:a>
									</div>
								</div>
							</div>
						</s:iterator>
					</s:else>
				</div>
	</s:if>

	<!-- 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        function reloadListProjet() {
            // URL de l'action AJAX
            var url = "<s:url action="searchSpotAjax"/>";

            // Action AJAX en POST
            jQuery.post(
                url,
                function (data) {
                    var $listProjet = jQuery("#listSpot");
                    $listSpot.empty();
                    jQuery.each(data, function (key, val) {
                        $listProjet.append(
                            jQuery("<li>")
                                .append(" - Nom du site : ")
                                .append(val.spotName)
                                
                        );
                    });
                })
                .fail(function () {
                    alert("Une erreur s'est produite.");
                });
        }
    </script>  -->
	<%@include file="include/footer.jsp"%>
</body>
</html>