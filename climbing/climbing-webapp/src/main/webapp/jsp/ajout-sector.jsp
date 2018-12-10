
	<%@include file="include/menu.jsp"%>

	<div class="container">

		<s:form action="ajoutsecteurOk" enctype="multipart/form-data"
			cssClass="form-horizontal" label="Ajouter un nouveau secteur">
			<s:hidden key="idSpot"></s:hidden>
			
			<s:textfield key="sectorBean.sectorName" />
			<s:submit value="Ajouter" cssClass="btn btn-primary center-block" />
		</s:form>
	</div>
	<%@include file="include/footer.jsp"%>

</body>
</html>