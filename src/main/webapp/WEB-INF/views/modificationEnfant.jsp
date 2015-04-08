

<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>







					<div id="content" class="col-lg-12 col-sm-12">
						<!-- content starts -->
						<div></div>

						<div class="row">
							<div class="box col-md-12">
								<div class="box-inner">
									<div class="box-header well" data-original-title="">
										<h2>
											<i class="glyphicon glyphicon-pencil"></i> <font
												color="#8C001A">Modification Enfant Actuel </font>
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
													<td><font color="#585858"><strong>Nom
																: *</strong></font></td>
													<td><f:input path="nom" /></td>
													<td><f:errors path="nom" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Prenom
																: *</strong></font></td>
													<td><f:input path="prenom" /></td>
													<td><f:errors path="prenom" cssClass="errors" /></td>
												</tr>


												<tr>
													<td><font color="#585858"><strong>Photo
																: * </strong></font></td>
													<td><c:if test="${enfant.idPerson!=null}">
															<img src="photoEnf?idEnfant=${enfant.idPerson}"
																class="images_petit" />

														</c:if></td>
													<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
												</tr>



												<tr>
													<td><font color="#585858"><strong>Sexe
																:</strong></font></td>
													<td>Homme <f:radiobutton path="sexe" value="Homme" />
														Femme <f:radiobutton path="sexe" value="Femme" />
													</td>
												</tr>


												<tr>
													<td><font color="#585858"><strong>Date
																Naissance : *</strong></font></td>
													<td><f:input type="date" path="dateNaissance" /></td>
													<td><f:errors path="dateNaissance" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Lieu
																Naissance:</strong></font></td>
													<td><f:input path="lieuNaissance" /></td>
													<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Langue
																: *</strong></font></td>
													<td><f:input path="langue" /></td>
													<td><f:errors path="langue" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Antecedants
																Medicaux</strong></font></td>
													<td><f:textarea path="antecedantsMedicaux" /></td>
													<td><f:errors path="antecedantsMedicaux"
															cssClass="errors" /></td>
												</tr>



												<tr>
													<td><font color="#585858"><strong>Situation
																Parentale :</strong></font></td>
													<td>Mariés <f:radiobutton path="situationParentale"
															value="Marie" /> Divorcés <f:radiobutton
															path="situationParentale" value="Divorce" /> Père Veuve
														<f:radiobutton path="situationParentale" value="Pere veuf" />
														Mère Veuve <f:radiobutton path="situationParentale"
															value="Mere veuve" />
													</td>
												</tr>


												<tr>
													<td><font color="#585858"><strong>Certifié?
														</strong></font></td>
													<td><f:checkbox path="certificatMedicale" /></td>
													<td><f:errors path="certificatMedicale"
															cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Autorisé
																pour la prise Photo?</strong></font></td>
													<td><f:checkbox path="autorisationPrisePhoto" /></td>
													<td><f:errors path="autorisationPrisePhoto"
															cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Nom
																& prenom Pediatre : </strong></font></td>
													<td><f:textarea path="nomPrenomPediatre" /></td>
													<td><f:errors path="nomPrenomPediatre"
															cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Telephone
																Portable Pediatre : </strong></font></td>
													<td><f:input path="telephonePortablePediatre" /></td>
													<td><f:errors path="telephonePortablePediatre"
															cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Nombre
																Frères : </strong></font></td>
													<td><f:input path="nombreFreres" /></td>
													<td><f:errors path="nombreFreres" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><font color="#585858"><strong>Nombre
																Soeurs : </strong></font></td>
													<td><f:input path="nombreSoeur" /></td>
													<td><f:errors path="nombreSoeur" cssClass="errors" /></td>
												</tr>



												<tr>

													<td>

														<button type="submit" class="btn btn-primary">
															<i class=" glyphicon glyphicon-ok"></i> Enregistrer
														</button>
													</td>

													<td>

														<button type="submit" class="btn btn-danger"
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
				