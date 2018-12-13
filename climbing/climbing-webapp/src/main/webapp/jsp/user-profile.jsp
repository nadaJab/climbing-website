<%@include file="include/menu.jsp"%>
<s:actionerror />
<s:fielderror />

<div class="row">
	<nav class="col-md-2 d-none d-md-block bg-light sidebar">
		<div class="sidebar-sticky">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link active" href="#"><span
						class="fas fa-home"></span>Mes infos personnelles </a></li>

				<li class="nav-item"><a class="nav-link" href="#profileUser"><span
						class="fas fa-address-book"></span>Mon profile </a></li>

				<li class="nav-item"><a class="nav-link" href="#topoUser"><span
						class="fas fa-file"></span>Mes Topos </a></li>

				<li class="nav-item"><a class="nav-link" href="#productUser"><span
						class="fas fa-cart-arrow-down"></span>Mes commandes</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="col-md-8 order-md-1" id="profileUser">
		<h4 class="mb-3">Mon profil</h4>
		<hr class="mb-4">
		
		<form class="needs-validation">
			<div class="row">
				<div class="col-md-6 mb-3">
					<s:textfield key="userBean.firstName"/>	
				</div>
				
				<div class="col-md-6 mb-3">
					<s:textfield key="userBean.lastName"/>	
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6 mb-3">
					<s:textfield key="userBean.pseudo"/>	
				</div>
				
				<div class="col-md-6 mb-3">
					<sj:datepicker key="userBean.birthYear" parentTheme="bootstrap"
					cssClass="form-control" elementCssClass="col-sm-5" showOn="focus"
					inputAppendIcon="calendar" />				
				</div>
			</div>
			
			<div class="mb-3">
					<s:textfield key="userBean.pseudo"/>	
			</div>

			<div class="mb-3">
				<s:textfield key="accountBean.email"/>
			<!--  <input type="email" class="form-control" id="email"
					placeholder="you@example.com">-->	
			</div>

			<div class="mb-3">
				<s:password key="accountBean.password" />
			</div>

			<div class="mb-3">
				<s:checkboxlist key="userBean.climbingType" labelposition="inline"
				list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}" />
			</div>

			<div class="mb-3">
				<sj:datepicker key="userBean.birthYear" parentTheme="bootstrap"
				cssClass="form-control" elementCssClass="col-sm-5" showOn="focus"
				inputAppendIcon="calendar" />
			</div>

			<button class="btn btn-primary center-block" type="submit">Modifier</button>
		</form>
					
		<div class="col-md-8 order-md-1" id="topoUser">
			<hr class="mb-4">
			<h4 class="mb-3">Mes topos</h4>
			<hr class="mb-4">	
			
		</div>
		
		<div class="col-md-8 order-md-1" id="productUser">
			<h4 class="mb-3">Mes commandes</h4>
			<hr class="mb-4">
			
		</div>
	
</div>
</body>
</html>