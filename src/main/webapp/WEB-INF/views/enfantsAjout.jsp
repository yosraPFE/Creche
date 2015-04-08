<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
	<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Ajouter Nouveau Enfant</title>

</head>

<body>

<!-- menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>






<!-- tables -->



<div>

<f:form modelAttribute="enfant" action="ajouterEnfant"
							method="get" enctype="multipart/form-data"   class="form-horizontal">

							<table>
								<tr>
									<!--  <td>ID</td>-->
									<td><f:input type="hidden" disabled="true" path="idPerson" /></td>
									<td><f:errors type="hidden" path="idPerson" cssClass="errors" /></td>
								</tr>

								


								<tr>
									<td> <i class="glyphicon glyphicon-tag  green">
									</i> <font color="#585858"><strong>Nom :</strong></font></td>
									<td><f:input path="nom" /></td>
									<td><f:errors path="nom" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-barcode  green">
									</i> <font color="#585858"><strong> Prenom : </strong></font></td>
									<td><f:input path="prenom" /></td>
									<td><f:errors path="prenom" cssClass="errors" /></td>
								</tr>
								
								
								
								<tr>
									<td> <i class="glyphicon glyphicon-camera green">
									</i> <font color="#585858"><strong> Photo :</strong></font></td>
									<c:if test="${enfant.idPerson!=0}">
											<img src="photoEnf?idEnfant=${enfant.idPerson}"
												class="images_petit" />
										</c:if>
									<td><input type="file" name="file" />
								</tr>
								
								
								
								<tr>
									<td><i class=" glyphicon glyphicon-user  green">
									</i> <font color="#585858"><strong> Sexe : </strong></font></td>
									<td> <f:radiobutton path="sexe" value="Homme" /> Homme
										<f:radiobutton path="sexe" value="Femme" /> Femme 
									</td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-calendar  green">
									</i><font color="#585858"><strong>
									Date Naissance: </strong></font></td>
									<td><f:input type="date" path="dateNaissance" /></td>
									<td><f:errors path="dateNaissance" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class=" glyphicon glyphicon-home  green">
									</i> <font color="#585858"><strong> Lieu Naissance: </strong></font></td>
									<td><f:input path="lieuNaissance" /></td>
									<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-flag  green">
									</i> <font color="#585858"><strong> Langue : </strong></font></td>
									<td><f:input path="langue" /></td>
									<td><f:errors path="langue" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class=" glyphicon glyphicon-list-alt  green">
									</i> <font color="#585858"><strong> Antecedants Medicaux : </strong></font></td>
									<td><f:textarea path="antecedantsMedicaux" /></td>
									<td><f:errors path="antecedantsMedicaux" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-heart  green">
									</i> <font color="#585858"><strong> Situation Parentale :  </strong></font></td>
									<td><f:radiobutton path="situationParentale"
											value="Marie" /> Mariés   <f:radiobutton
											path="situationParentale" value="Divorce" /> Divorcés <f:radiobutton
											path="situationParentale" value="Pere veuf" /> Père Veuve   <f:radiobutton
											path="situationParentale" value="Mere veuve" /> Mère Veuve
									</td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-thumbs-up  green">
									</i> <font color="#585858"><strong> Certifié? </strong></font></td>
									<td><f:checkbox path="certificatMedicale" /></td>
									<td><f:errors path="certificatMedicale" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class=" glyphicon glyphicon-facetime-video  green">
									</i> <font color="#585858"><strong>Autorisé pour la prise Photo? </strong></font></td>
									<td><f:checkbox path="autorisationPrisePhoto" /></td>
									<td><f:errors path="autorisationPrisePhoto"
											cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-briefcase  green">
									</i> <font color="#585858"><strong>Nom & prenom Pediatre : </strong></font></td>
									<td><f:textarea path="nomPrenomPediatre" /></td>
									<td><f:errors path="nomPrenomPediatre" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-phone  green">
									</i> <font color="#585858"><strong>Telephone Portable Pediatre : </strong></font></td>
									<td><f:input path="telephonePortablePediatre" /></td>
									<td><f:errors path="telephonePortablePediatre"
											cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-tree-conifer green">
									</i> <font color="#585858"><strong>Nombre Frères :</strong></font></td>
									<td><f:input path="nombreFreres" /></td>
									<td><f:errors path="nombreFreres" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-tree-deciduous green">
									</i> <font color="#585858"><strong>Nombre Soeurs : </strong></font></td>
									<td><f:input path="nombreSoeur" /></td>
									<td><f:errors path="nombreSoeur" cssClass="errors" /></td>
								</tr>


                           <tr>

								
									<td><input type="submit"
										value="Ajouter et afficher details" /></td>
								</tr>
								
								
								
								
							</table>

						</f:form>
     </div>
                     
                     
                     
                     
                    
                          
                     
                    
                    
  




	
<!-- footer -->


	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>




</body>
</html>
