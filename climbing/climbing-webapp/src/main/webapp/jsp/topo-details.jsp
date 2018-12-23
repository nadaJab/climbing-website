<%@include file="include/menu.jsp"%>

<s:actionerror />

<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-sm">

				<div class="card">
					<div class="card-header">
						<s:property value="topoBean.topoName" />
					</div>
					<div class="card-body">

						<p>
						<h6>Auteur :</h6>
						<s:property value="topoBean.author" />

						<h6>Annèe d'edition :</h6>
						<s:property value="topoBean.editionYear" />
						<h6>Nombre des copies :</h6>
						<s:property value="topoBean.nbCopyMax" />
						<h6>Publiè le :</h6>
						<s:property value="topoBean.published" />
						<br />
						</p>

					</div>
				</div>
			</div>
			<div class="col-sm">
				<div class="card">
					<div class="card-header">Réservation</div>
					<div class="card-body">

						<s:form action="bookingOk" theme="simple">
							<!-- 
							<input name="bookingTopoBean.borrowingDate" id="startDate" width="200" placeholder="Date de réservation" />
							<input  name="bookingTopoBean.returnDate" id="endDate" width="200" placeholder="Date de retour"/> 
							-->
							<br>
							<sx:datetimepicker name="bookingTopoBean.borrowingDate"
								label="Date de réservation" displayFormat="dd-MMM-yyyy" />
							<sx:datetimepicker name="bookingTopoBean.returnDate"
								label="Date de retour" displayFormat="dd-MMM-yyyy" />

							<s:hidden key="idTopo" />

							<s:submit cssClass="btn btn-info" value="Réserver" />
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- **** Affichage des photos -->
	<div class="container">
	<div class="row justify-content-lg-center">
		<div class="col-sm-12">
	<div class="card">
		<div class="card-body">

			<img src="..." alt="..." class="rounded mx-auto d-block">

		</div>
	</div></div></div></div>

	<!-- **** champs commentaire-->
	<div class="container">
	<div class="row justify-content-lg-center">
		<div class="col-sm-12">
		
	<div class="card">
		<div class="card-header">Commentaire</div>
		<div class="card-body">
			<s:if test="commentTopo.empty">
				<div class="row justify-content-lg-center">
					<p class="text-center grossissement">Aucun commentaire ajouté</p>
				</div>
			</s:if>

			<s:else>
				<s:iterator value="commentTopo">
					<div class="list">
						<div class="card">
							<div class="card-body">

								<s:property value="user.pseudo" />
								:
								<s:property value="content" />
								<s:property value="dateComment" />
								.
								<s:if test="#session.user.role == 'admin'">
									<s:a action="deleteCommentTopo" class="btn btn-outline-danger">
										<span class="fas fa-trash-alt"></span>

										<s:hidden key="idTopo" />
										<s:param name="idTopo" value="idTopo" />
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
		
			<s:form action="ajoutCommentaireTopo" validate="true" theme="bootstrap"
				cssClass="form-horizontal">
				<s:textfield key="commentBean.content"
					placeholder="Votre commentaire...." />
				<s:hidden key="idTopo" />
				<s:hidden key="#session.user.idUser"></s:hidden>

				<s:submit value="Ajouter"
					cssClass="btn btn-primary btn-sm center-block" />
			</s:form>
		</div>
	</div>

</div>
</div></div></div>
<!--  
<script>
        var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
        $('#startDate').datepicker({
            uiLibrary: 'bootstrap4',
            iconsLibrary: 'fontawesome',
            minDate: today,
            maxDate: function () {
                return $('#endDate').val();
            }
        });
        $('#endDate').datepicker({
            uiLibrary: 'bootstrap4',
            iconsLibrary: 'fontawesome',
            minDate: function () {
                return $('#startDate').val();
            }
        });
    </script>
-->
</body>
</html>