
	<%@include file="include/menu.jsp"%>

	<div class="container">
		
		<s:form action="ajoutsiteOk" theme="bootstrap" validate="true" cssClass="form-horizontal" label="Ajouter un nouveau site">

			<s:textfield key="spotBean.spotName"/>
			<s:textfield key="spotBean.nbRoutesTotal"/>
			<s:select key="spotBean.cotationMin"
				list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
				emptyOption="true"/>

			<s:select key="spotBean.cotationMax"
				list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
				emptyOption="true"/>

			<s:checkboxlist key="spotBean.orientation" labelposition="inline"
				list="{'N', 'NE', 'E', 'SE', 'S', 'SO', 'O', 'NO'}"/>

			<s:checkboxlist key="spotBean.climbingType" labelposition="inline"
				list="{'Bloc', 'Voie', 'Grande voie', 'Trad', 'Artif', 'Deep water', 'Via-ferrata'}"/>
			
			<s:textfield key="countryBean.cityName"/>
			<s:textfield key="countryBean.countryName"/>

			<s:submit value="Ajouter" cssClass="btn btn-primary center-block" />
		</s:form>
	</div>
	<%@include file="include/footer.jsp"%>
</body>
</html>