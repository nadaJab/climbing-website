<%@include file="include/menu.jsp"%>

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
						<button type="button" class="btn btn-info">Réserver</button> 	

					</div>
				</div>
			</div>
			<div class="col-sm">
				<div class="card">
					<div class="card-body">
						
						<img src=""></img>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>