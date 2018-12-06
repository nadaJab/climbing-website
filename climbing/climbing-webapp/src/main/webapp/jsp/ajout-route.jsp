
	<%@include file="include/menu.jsp"%>

	<div class="container">
		
		<s:form action="ajoutligneOk" enctype="multipart/form-data"
			cssClass="form-horizontal" label="Ajouter une nouvelle ligne">
			<s:hidden key="idSector"></s:hidden>
			
			<s:textfield key="routeBean.routeName"/>

			<s:select key="routeBean.cotation"
				list="{'3a', '3b', '3c',
                        	   '4a', '4b', '4c',
                        	   '5a', '5b', '5c',
                        	   '6a', '6b', '6c',
                        	   '7a', '7b', '7c',
                        	   '8a', '8b', '8c',
                        	   '9a', '9b', '9c'}"
				emptyOption="true"/>

			<s:textfield key="routeBean.height"/>
			<s:textfield key="routeBean.pointNumber"/>
			<s:textfield key="routeBean.routeOpener"/>
			<s:textfield key="routeBean.openingYear"/>

			<s:submit value="Ajouter" cssClass="btn btn-primary center-block" />
		</s:form>
	</div>
	<%@include file="include/footer.jsp"%>

</body>
</html>