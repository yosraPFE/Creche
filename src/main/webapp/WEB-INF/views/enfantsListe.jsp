<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Enfants</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<div></div>

			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${enfant.idPerson!=0}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${enfant.idPerson==0}">
							<div class="box-content">
						</c:if>

						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Photo</th>
									<th>Nom</th>
									<th>Prenom</th>
									<th>Date Naissance</th>
									<th>Certifié?</th>
									<th>Autorisé photos?</th>
									<th>Situation Parentale</th>
									<th>Actions</th>

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${enfants}" var="en">
									<tr>






										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoEnf?idEnfant=${en.idPerson}" class="images_petit"
											title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoEnf?idEnfant=${en.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>
										<td class="center">${en.nom}</td>
										<td class="center">${en.prenom}</td>
										<td class="center">${en.dateNaissance}</td>


										<c:if test="${en.certificatMedicale==true}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-ok"></i>
												</button></td>
										</c:if>

										<c:if test="${en.certificatMedicale==false}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-remove"></i>
												</button></td>
										</c:if>



										<c:if test="${en.autorisationPrisePhoto==true}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-ok"></i>
												</button></td>
										</c:if>

										<c:if test="${en.autorisationPrisePhoto==false}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-remove"></i>
												</button></td>
										</c:if>




										<td class="center">${en.situationParentale}</td>

										<td><a class="btn btn-danger" title="Supprimer Enfant"
											data-toggle="tooltip"
											href="supprimerListeEnfant?idEnfant=${en.idPerson}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${en.nom} ${en.prenom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a> <a class="btn btn-info" title="Modifier Enfant"
											data-toggle="tooltip"
											href="modifierListeEnfant?idEnfant=${en.idPerson}"
											onclick="modifierListeEnfant?idEnfant=${en.idPerson}"> <i
												class="glyphicon glyphicon-edit icon-white"></i></a> <a
											class="btn btn-success" title="Voir details"
											data-toggle="tooltip" href="#"> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>


						</table>






						<div style="text-align: center">


							<c:if test="${page!=0}">

								<span> <a class="btn btn-primary btn-xs"
									href="indexPage?page=${page-1}"><< Précédent</a>
								</span>
							</c:if>
							<c:forEach begin="0" end="${nbrPages-1}" var="p">



								<c:choose>

									<c:when test="${(p)==page}">
										<span><a class="btn btn-info btn-xs">Page ${p+1}</a></span>
									</c:when>
									<c:otherwise>

										<span> <a class="btn btn-primary btn-xs"
											href="indexPage?page=${p}">Page ${p+1}</a>
										</span>

									</c:otherwise>

								</c:choose>
							</c:forEach>

							<c:if test="${page!=nbrPages-1}">

								<span> <a class="btn btn-primary btn-xs"
									href="indexPage?page=${page+1}">Suivant >></a>
								</span>
							</c:if>

						</div>

					</div>



					<c:if test="${enfant.idPerson!=0}">
						<div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>

							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification de l'Enfant :
													${enfant.nom} ${enfant.prenom}</font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="enfant"
												action="validerModificationEnf" method="post"
												enctype="multipart/form-data">


												<table>


													<f:input type="hidden" path="idPerson" />
													<f:errors type="hidden" path="idPerson" cssClass="errors" />





													<tr>
														<td> <i class="glyphicon glyphicon-tag  blue">
									</i><font color="#585858"><strong> Nom
																	: * </strong></font></td>
														<td><f:input path="nom" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class="glyphicon glyphicon-barcode  blue">
									</i> <font color="#585858"><strong> Prenom
																	: *</strong></font></td>
														<td><f:input path="prenom" /></td>
														<td><f:errors path="prenom" cssClass="errors" /></td>
													</tr>


													<tr>
														<td> <i class="glyphicon glyphicon-camera blue">
									</i> <font color="#585858"><strong> Photo
																	: * </strong></font></td>
														<td><c:if test="${enfant.idPerson!=null}">
																<img src="photoEnf?idEnfant=${enfant.idPerson}"
																	class="images_petit" />

															</c:if></td>
														<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
													</tr>



													<tr>
														<td> <i class=" glyphicon glyphicon-user  blue">
									</i> <font color="#585858"><strong> Sexe
																	:</strong></font></td>
														<td><f:radiobutton path="sexe" value="Homme" /> Homme
															<f:radiobutton path="sexe" value="Femme" /> Femme</td>
													</tr>


													<tr>
														<td> <i class="glyphicon glyphicon-calendar  blue">
									</i> <font color="#585858"><strong>Date
																	Naissance : *</strong></font></td>
														<td><f:input type="date" path="dateNaissance" /></td>
														<td><f:errors path="dateNaissance" cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class=" glyphicon glyphicon-home  blue">
									</i><font color="#585858"> <strong>Lieu
																	Naissance:</strong></font></td>
														<td><f:input path="lieuNaissance" /></td>
														<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
													</tr>



													<tr>
														<td> <i class="glyphicon glyphicon-flag  blue">
									</i> <font color="#585858"><strong>Langue
																	: *</strong></font></td>
														<td><f:select path="langue" id="selectError"
																data-rel="chosen">
																<f:option value="Arabe" />
																<f:option value="Français" />
																<f:option value="Anglais" />
															</f:select></td>
														<td><f:errors path="langue" cssClass="errors" /></td>
													</tr>


													<tr>
														<td> <i class=" glyphicon glyphicon-list-alt  blue">
									</i> <font color="#585858"> <strong>Antecedants
																	Medicaux</strong></font></td>
														<td><f:textarea path="antecedantsMedicaux" /></td>
														<td><f:errors path="antecedantsMedicaux"
																cssClass="errors" /></td>
													</tr>



													<tr>
														<td> <i class="glyphicon glyphicon-heart  blue">
									</i> <font color="#585858"> <strong>Situation
																	Parentale :</strong></font></td>
														<td><f:radiobutton path="situationParentale"
																value="Marie" /> Mariés <f:radiobutton
																path="situationParentale" value="Divorce" /> Divorcés <f:radiobutton
																path="situationParentale" value="Pere veuf" /> Père
															Veuve <f:radiobutton path="situationParentale"
																value="Mere veuve" /> Mère Veuve</td>
													</tr>


													<tr>
														<td> <i class="glyphicon glyphicon-thumbs-up  blue">
									</i> <font color="#585858"> <strong>Certifié?
															</strong></font></td>
														<td><f:checkbox path="certificatMedicale" /></td>
														<td><f:errors path="certificatMedicale"
																cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class=" glyphicon glyphicon-facetime-video  blue">
									</i> <font color="#585858"> <strong>Autorisé
																	pour la prise Photo?</strong></font></td>
														<td><f:checkbox path="autorisationPrisePhoto" /></td>
														<td><f:errors path="autorisationPrisePhoto"
																cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class="glyphicon glyphicon-briefcase  blue">
									</i><font color="#585858"> <strong>Nom
																	& prenom Pediatre : </strong></font></td>
														<td><f:input path="nomPrenomPediatre" /></td>
														<td><f:errors path="nomPrenomPediatre"
																cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class="glyphicon glyphicon-phone  blue">
									</i> <font color="#585858"> <strong>Telephone
																	Portable Pediatre : </strong></font></td>
														<td><f:input path="telephonePortablePediatre" /></td>
														<td><f:errors path="telephonePortablePediatre"
																cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class="glyphicon glyphicon-tree-conifer blue">
									</i> <font color="#585858"> <strong>Nombre
																	Frères : </strong></font></td>
														<td><f:input path="nombreFreres" /></td>
														<td><f:errors path="nombreFreres" cssClass="errors" /></td>
													</tr>

													<tr>
														<td> <i class="glyphicon glyphicon-tree-deciduous blue">
									</i> <font color="#585858"><strong>Nombre
																	Soeurs : </strong></font></td>
														<td><f:input path="nombreSoeur" /></td>
														<td><f:errors path="nombreSoeur" cssClass="errors" /></td>
													</tr>



													<tr>

														<td>

															<button type="submit" class="btn btn-success"
																title="Enregistrer la modification"
																data-toggle="tooltip">
																<i class=" glyphicon glyphicon-ok"></i> Valider
															</button>
														</td>

														<td>

															<button type="submit" class="btn btn-danger"
																title="Annuler et retourner à la liste des Enfants"
																data-toggle="tooltip"
																href="<c:url value="/adminEnf/index"/>">
																<i class=" glyphicon glyphicon-remove"></i> Annuler
															</button>
														</td>

													</tr>



												</table>


											</f:form>




										</div>
									</div>
								</div>

							</div>




						</div>
					</c:if>


				</div>
			</div>
		</div>
	</div>

	</div>




	</div>
	</div>
	
	<!-- footer -->

	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>