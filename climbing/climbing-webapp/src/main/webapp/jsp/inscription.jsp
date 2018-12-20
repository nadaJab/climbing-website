
	<%@include file="include/menu.jsp"%>

	<div class="container">

		<s:form action="save" validate="true" theme="bootstrap" cssClass="form-horizontal" label="Créer un compte">

			<s:textfield key="userBean.lastName" />
			<s:textfield key="userBean.firstName" />
			<s:textfield key="userBean.pseudo" />
			<sj:datepicker key="userBean.birthYear" parentTheme="bootstrap"
				cssClass="form-control" elementCssClass="col-sm-5" showOn="focus"
				inputAppendIcon="calendar" />
			<s:radio key="userBean.sexe" labelposition="inline"
				list="{'Femme', 'Homme'}" cssErrorClass="foo" />
			<s:checkboxlist key="userBean.climbingType" labelposition="inline"
				list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}" />
			<s:textfield key="accountBean.email"
				placeholder="adresse@exemple.com" />
			<s:password key="accountBean.password" />
			
			<s:submit value="Enregistrer" cssClass="btn btn-primary center-block" />

		</s:form>
	</div>

	<%@include file="include/footer.jsp"%>

</body>
</html>