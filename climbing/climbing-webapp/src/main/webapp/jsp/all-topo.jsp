
<%@include file="include/menu.jsp"%>
<s:actionerror />
<s:fielderror />

	<div class="container content">
	<br/>
		<s:if test="topos.empty">
			<div class="row justify-content-lg-center">
				<p class="text-center grossissement">Aucun Topo n'a été trouvé</p>
			</div>
		</s:if>

		<s:else>
			<s:iterator value="topos">
				<div class="list">
					<div class="card">
						<div class="card-header"></div>
						<div class="card-body">
							<h5 class="card-title">
								<s:property value="topoName" />
							</h5>

							<s:a action="topoDetails" class="btn btn-primary"><span
							class="fas fa-file-image"></span><s:hidden key="idTopo" /><s:param name="idTopo" value="idTopo" />
							Voir topo</s:a>

						</div>
					</div>
				</div>
				<br/>
			</s:iterator>
		</s:else>
	</div>

<br/>
<%@include file="include/footer.jsp"%>

</body>
</html>