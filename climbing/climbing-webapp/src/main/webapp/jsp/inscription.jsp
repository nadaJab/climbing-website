
	<%@include file="include/menu.jsp"%>
	<s:actionerror />
    <s:actionmessage/>
	<div class="container">

		<s:form action="save" validate="true" theme="bootstrap" cssClass="form-horizontal" label="Créer un compte">

			<s:textfield key="userBean.lastName" />
			<s:textfield key="userBean.firstName" />
			<s:textfield key="userBean.pseudo" />
			
			<s:textfield name="userBean.birthYear" type="date" id="startDate" width="200"/>
			
		
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
    </script>
    
	<%@include file="include/footer.jsp"%>

</body>
</html>