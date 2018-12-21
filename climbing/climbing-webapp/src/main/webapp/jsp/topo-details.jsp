<%@include file="include/menu.jsp"%>

		<s:actionerror/>

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
							<sx:datetimepicker name="bookingTopoBean.borrowingDate" label="Date de réservation" displayFormat="dd-MMM-yyyy" />
							<sx:datetimepicker name="bookingTopoBean.returnDate" label="Date de retour" displayFormat="dd-MMM-yyyy" />
							
							<s:hidden key="idTopo" />
							
							<s:submit cssClass="btn btn-info" value="Réserver"/>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- **** -->
	<div class="card">
		<div class="card-body">

			<img src="..." alt="..." class="rounded mx-auto d-block">

		</div>
	</div>


</div>

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