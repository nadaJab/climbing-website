
<%@include file="include/menu.jsp"%>

<div class="container">
	<s:form action="ajouttopoOk" method="post"
		enctype="multipart/form-data" cssClass="form-horizontal"
		label="Ajouter un nouveau topo">

		<s:textfield key="topoBean.topoName" />
		<s:textfield key="topoBean.author" />
		<s:textfield key="topoBean.nbCopyMax"
			tooltip="Donner le nombre d'exemplaires que vous disposez" />
		<s:textfield key="topoBean.editionYear"
			tooltip="L'année d'édition du topo" />

		<s:file label="Image de couverture" name="upload" />
  		<s:file label="Image extrait" name="upload" />
  		
		<s:hidden key="idSpot" />
		<s:hidden key="#session.user.idUser"></s:hidden>

		<s:submit cssClass="btn btn-primary" />
	</s:form>
</div>

<%@include file="include/footer.jsp"%>
</body>
</html>