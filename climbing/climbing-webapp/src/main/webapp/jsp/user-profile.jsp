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
<<<<<<< HEAD
						class="fas fa-cart-arrow-down"></span> Mes commandes </a></li>

				<s:if test="#session.user.role == 'admin'">
					<li class="nav-item"><a class="nav-link" href="#users"><span
							class="fas fa-users"></span> Users </a></li>
=======
						class="fas fa-cart-arrow-down"></span> Mes commandes</a></li>

				<s:if test="#session.user.role == 'admin'">
					<li class="nav-item"><a class="nav-link" href="#users"><span
							class="fas fa-users"></span> Users</a></li>
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
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
			<hr class="mb-4">

		</div>

		<div id="productUser">
			<h4 class="mb-3">Mes commandes</h4>
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
<<<<<<< HEAD

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
										<span class="fas fa-edit"></span></button>
									</s:form></td>
=======
								<td><select id="inputState" class="form-control">
										<option selected><s:property value="role" /></option>
										<option>
										<s:if test="#session.user.role == 'admin'">utilisateur</s:if>
										<s:elseif test="#session.user.role == 'utilisateur'"> admin</s:elseif>
										</option>	
								</select></td>
								<td><s:a action=""><span class="fas fa-edit"></span>
								<s:hidden key="idUser" />
								</s:a></td>
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
							</tr>
						</s:iterator>

					</tbody>
				</table>

			</s:if>
		</div>

	</div>
</div>
</body>
</html>