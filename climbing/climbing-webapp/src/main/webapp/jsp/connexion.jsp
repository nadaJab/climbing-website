
	<%@include file="include/menu.jsp"%>

	<div class="container">
	
		<s:form action="connexionOK" validate="true" theme="bootstrap" cssClass="form-horizontal" label="Connexion">

			<s:textfield key="accountBean.email"
				placeholder="adresse@exemple.com" />

			<s:password key="accountBean.password" />

			<s:submit value="Connecter" id="connecter"
				cssClass="btn btn-primary center-block" />
		</s:form>

	</div>
	<%@include file="include/footer.jsp"%>
</body>
</html>