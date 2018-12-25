<%@include file="include/menu.jsp"%>
<s:actionerror />
<s:fielderror />

<div class="row">
	<nav class="col-md-2 d-none d-md-block bg-light sidebar">
		<div class="sidebar-sticky">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link active" href="#"><span
						class="fas fa-home"></span> Mes infos personnelles </a></li>

				<li class="nav-item"><a class="nav-link" href="#profileUser"><span
						class="fas fa-address-book"></span> Mon profile </a></li>

				<li class="nav-item"><a class="nav-link" href="#topoUser"><span
						class="fas fa-file"></span> Mes Topos </a></li>

				<li class="nav-item"><a class="nav-link" href="#productUser"><span
						class="fas fa-cart-arrow-down"></span> Mes commandes </a></li>

				<s:if test="#session.user.role == 'admin'">
					<li class="nav-item"><a class="nav-link" href="#users"><span
							class="fas fa-users"></span> Users </a></li>
				</s:if>
			</ul>
		</div>
	</nav>

	<div class="col-md-8 order-md-1">

		<div id="profileUser">
			<s:if test="#session.user.role == 'admin'">
				<h4 class="mb-3">Mon profil -admin-</h4>
			</s:if>
			<s:else>
				<h4 class="mb-3">Mon profil</h4>
			</s:else>
			<hr class="mb-4">

			<s:form action="updateUser">
				<div class="row">
					<div class="col-md-6 mb-3">
						<s:textfield key="userBean.firstName"
							value="%{session.user.firstName}" />

					</div>

					<div class="col-md-6 mb-3">
						<s:textfield key="userBean.lastName"
							value="%{session.user.lastName}" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-6 mb-3">
						<s:textfield key="userBean.pseudo" value="%{session.user.pseudo}" />
					</div>

					<div class="col-md-6 mb-3">
						<sj:datepicker key="userBean.birthYear" parentTheme="bootstrap"
							cssClass="form-control" elementCssClass="col-sm-5" showOn="focus"
							inputAppendIcon="calendar" value="%{session.user.birthYear}" />
					</div>
				</div>

				<div class="mb-3">
					<s:textfield key="accountBean.email"
						value="%{session.user.account.email}" />
					<!--  <input type="email" class="form-control" id="email"
					placeholder="you@example.com">-->
				</div>

				<div class="mb-3">
					<s:password key="accountBean.password" />
				</div>

				<div class="mb-3">
					<s:checkboxlist key="userBean.climbingType" labelposition="inline"
						list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"
						onclick="%{session.user.climbingType}" />
				</div>

				<button class="btn btn-primary center-block" type="submit">Modifier</button>
			</s:form>
		</div>
		<div id="topoUser">
			<hr class="mb-4">
			<h4 class="mb-3">Mes topos</h4>
			<s:if test="listTopo.empty">
				<div class="row justify-content-lg-center">
					<p class="text-center grossissement">Vous n'avez aucun Topo en ligne</p>
				</div>
			</s:if>
			<s:else>
			<table class="table table-bordered">
				<thead>
					<tr class="table-primary">
						<th scope="col">Nom du topo</th>
						<th scope="col">Nombre d'exemplaire</th>
						<th scope="col">Ajoutè le</th>
					</tr>
				</thead>
				<tbody>

					<s:iterator value="listTopo">
						<tr>
							<td><s:property value="topoName" /></td>
							<td><s:property value="nbCopyMax" /></td>
							<td><s:property value="published" /></td>
							<td><s:a action="deleteTopo" class="btn btn-outline-danger">
									<span class="fas fa-trash-alt"></span>
									<s:hidden key="idTopo" />
									<s:param name="idTopo" value="idTopo" />
								</s:a></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
			</s:else>
			
			<h6>Topo en réservation :</h6>
			<s:if test="bookingTopoList.empty">
				<div class="row justify-content-lg-center">
					<p class="text-center grossissement">Aucun topo réservé</p>
				</div>
			</s:if>
			<s:else>
				<table class="table table-bordered">
					<thead>
						<tr class="table-primary">
							<th scope="col">Nom du topo</th>
							<th scope="col">Réservé par</th>
							<th scope="col">Email</th>
							<th scope="col">Date de réservation</th>
							<th scope="col">Date de retour</th>
							<th scope="col">Retour Ok</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="bookingTopoList">
							<tr>
								<td><s:property value="topoBean.topoName" /></td>
								<td><s:property value="userBean.firstName" /> 
								<s:property value="userBean.lastName" /></td>
								<td><s:property value="userBean.account.email" /></td>
								<td><s:property value="borrowingDate" /></td>
								<td><s:property value="returnDate" /></td>

								<td><s:a action="returnOk" class="btn btn-outline-danger">
										<span class="fas fa-exchange-alt"></span>
										<s:hidden key="idTopo" />
										<s:param name="idTopo" value="idTopo" />
									</s:a></td>

							</tr>
						</s:iterator>


					</tbody>
				</table>
			</s:else>
			<hr class="mb-4">

		</div>

		<div id="productUser">
			<h4 class="mb-3">Mes commandes</h4>
			<s:if test="Commandes.empty">
				<div class="row justify-content-lg-center">
					<p class="text-center grossissement">Vous n'avez aucune commande</p>
				</div>
			</s:if>
			<s:else>
				<table class="table table-bordered">
					<thead>
						<tr class="table-primary">
							<th scope="col">Nom du topo</th>		
							<th scope="col">Date de réservation</th>
							<th scope="col">Retour Ok</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="Commandes">
							<tr>
								<td><s:property value="topoBean.topoName" /></td>
								<td><s:property value="borrowingDate" /></td>
							    <td><s:property value="returnConfirmation" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:else>
			<hr class="mb-4">

		</div>


		<div id="users">

			<s:if test="#session.user.role == 'admin'">
				<h4 class="mb-3">Users</h4>
				<hr class="mb-4">

				<table class="table">
					<caption>La liste des utilisateurs</caption>
					<thead>
						<tr class="table-primary">
							<th scope="col">Nom</th>
							<th scope="col">Prénom</th>
							<th scope="col">Pseudo</th>
							<th scope="col">Type de grimpe</th>
							<th scope="col">Genre</th>
							<th scope="col">Role</th>
						</tr>
					</thead>
					<tbody>

						<s:iterator value="listUsers">
							<tr>
								<td><s:property value="lastName" /></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="pseudo" /></td>
								<td><s:property value="climbingType" /></td>
								<td><s:property value="sexe" /></td>

								<!-- un champs input pour modifier role user par l'admin -->
								<td><s:form action="updateRole">
										<select name="userBean.role" class="form-control">
											<option selected><s:property value="role" /></option>
											<option>
												<s:if test="role=='admin'">utilisateur</s:if>
												<s:elseif test="role=='utilisateur'">admin</s:elseif>
											</option>
										</select>
										<button class="btn btn-primary" type="submit">
											<s:hidden key="idUser" />
											<span class="fas fa-edit"></span>
										</button>
									</s:form></td>
							</tr>
						</s:iterator>

					</tbody>
				</table>

			</s:if>
		</div>

	</div>
</div>
<%@include file="include/footer.jsp"%>

</body>
</html>