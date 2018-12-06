
	<%@include file="include/menu.jsp"%>

	<div class="container">
		<s:actionerror />
		<s:actionmessage />
		<s:fielderror />

		<s:form action="ajoutsiteOk" enctype="multipart/form-data"
			cssClass="form-horizontal" label="Ajouter un nouveau topo">

			<s:textfield key="topoBean.topoName"/>

			<s:textfield key="topoBean.author"/>

			<s:textfield key="topoBean.nbCopyMax"
				tooltip="Donner le nombre d'exemplaires que vous disposez" />

			<s:textfield key="topoBean.editionYear" tooltip="L'année d'édition du topo" />

			<s:file key="topoBean.imageURL"/>

			<s:submit cssClass="btn btn-primary" />
		</s:form>
	</div>
	<%@include file="include/footer.jsp"%>
</body>
</html>