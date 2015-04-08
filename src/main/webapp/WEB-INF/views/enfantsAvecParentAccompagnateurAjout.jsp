<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
	<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Ajouter Nouveau Enfant</title>
<!--  
<script type="text/javascript">
submitForms = function(){
	$('#accompForm :input').not(':submit').clone().hide().appendTo('#parentForm');
	$('#parentForm :input').not(':submit').clone().hide().appendTo('#enfantForm');

	document.getElementById("enfantForm").submit();
}
</script>-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>

$(document).ready(function() {
    $("#subbut").click(function() {
        $.post($("#enfantForm").attr("action"), $("#enfantForm").serialize(),
          function(data) {
            
            $.post($("#parentForm").attr("action"), $("#parentForm").serialize(),
            function(data) {
                
                $.post($("#accompForm").attr("action"), $("#accompForm").serialize(),
                		function() {
                	alert('Both forms submitted');
                });
              });
          });
      });
  });

</script>
</head>

<body>

<!-- menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>





<!-- tables -->



<div class="row">
    <div class="box col-md-9"> 
        <div class="box-inner homepage-box">
            <div class="box-header well">
                <h2><i class=" glyphicon glyphicon-plus"></i> <font color="#8C001A">Ajouter Nouveau Enfant</font></h2>
   
            </div>

            <div class="box-content">
             <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a href="#info"><i class="glyphicon glyphicon-briefcase"> </i> <strong> Coordinations Enfant</strong></a></li>
                    <li><a href="#custom"><i class="glyphicon glyphicon-home"> </i> <strong>Coordinations Parent</strong></a></li>
                    <li><a href="#messages"><i class=" glyphicon glyphicon-eye-open"> </i> <strong>Coordinations Accompagnateur</strong></a></li>
            </ul>
    
                  <!-- table Enfant -->
                  
                  <div id="myTabContent" class="tab-content">
	<div class="tab-pane active" id="info">
		<h3>
			<legend>Veuillez Remplir le Formulaire Enfant :</legend>

			<f:form modelAttribute="enfant" action="ajouterEnfantPA"
			method="post" enctype="multipart/form-data"   class="form-horizontal" id="enfantForm">

			<table>
				<tr>
					<!--  <td>ID</td>-->
					<td><f:input type="hidden" disabled="true" path="idPerson" /></td>
					<td><f:errors type="hidden" path="idPerson" cssClass="errors" /></td>
				</tr>




				<tr>
					<td> <i class="glyphicon glyphicon-tag  blue">
					</i> <font color="#585858"><strong>Nom :</strong></font></td>
					<td><f:input path="nom" /></td>
					<td><f:errors path="nom" cssClass="errors" /></td>
				</tr>

				<tr>
					<td><i class="glyphicon glyphicon-barcode  blue">
					</i> <font color="#585858"><strong> Prenom : </strong></font></td>
					<td><f:input path="prenom" /></td>
					<td><f:errors path="prenom" cssClass="errors" /></td>
				</tr>



				<tr>
					<td> <i class="glyphicon glyphicon-camera blue">
					</i> <font color="#585858"><strong> Photo :</strong></font></td>
					<c:if test="${enfant.idPerson!=0}">
					<img src="photoEnf?idEnfant=${enfant.idPerson}"
					class="images_petit" />
				</c:if>
				<td><input type="file" name="file" />
				</tr>



				<tr>
					<td><i class=" glyphicon glyphicon-user  blue">
					</i> <font color="#585858"><strong> Sexe : </strong></font></td>
					<td> <f:radiobutton path="sexe" value="Homme" /> Homme
						<f:radiobutton path="sexe" value="Femme" /> Femme 
					</td>
				</tr>

				<tr>
					<td><i class="glyphicon glyphicon-calendar  blue">
					</i><font color="#585858"><strong>
					Date Naissance: </strong></font></td>
					<td><f:input type="date" path="dateNaissance" /></td>
					<td><f:errors path="dateNaissance" cssClass="errors" /></td>
				</tr>


				<tr>
					<td><i class=" glyphicon glyphicon-home  blue">
					</i> <font color="#585858"><strong> Lieu Naissance: </strong></font></td>
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
					<td><i class=" glyphicon glyphicon-list-alt  blue">
					</i> <font color="#585858"><strong> Antecedants Medicaux : </strong></font></td>
					<td><f:textarea path="antecedantsMedicaux" /></td>
					<td><f:errors path="antecedantsMedicaux" cssClass="errors" /></td>
				</tr>


				<tr>
					<td><i class="glyphicon glyphicon-heart  blue">
					</i> <font color="#585858"><strong> Situation Parentale :  </strong></font></td>
					<td><f:radiobutton path="situationParentale"
						value="Marie" /> Mariés   <f:radiobutton
						path="situationParentale" value="Divorce" /> Divorcés <f:radiobutton
						path="situationParentale" value="Pere veuf" /> Père Veuve   <f:radiobutton
						path="situationParentale" value="Mere veuve" /> Mère Veuve
					</td>
				</tr>


				<tr>
					<td><i class="glyphicon glyphicon-thumbs-up  blue">
					</i> <font color="#585858"><strong> Certifié? </strong></font></td>
					<td><f:checkbox path="certificatMedicale" /></td>
					<td><f:errors path="certificatMedicale" cssClass="errors" /></td>
				</tr>


				<tr>
					<td><i class=" glyphicon glyphicon-facetime-video  blue">
					</i> <font color="#585858"><strong>Autorisé pour la prise Photo? </strong></font></td>
					<td><f:checkbox path="autorisationPrisePhoto" /></td>
					<td><f:errors path="autorisationPrisePhoto"
						cssClass="errors" /></td>
					</tr>


					<tr>
						<td><i class="glyphicon glyphicon-briefcase  blue">
						</i> <font color="#585858"><strong>Nom & prenom Pediatre : </strong></font></td>
						<td><f:textarea path="nomPrenomPediatre" /></td>
						<td><f:errors path="nomPrenomPediatre" cssClass="errors" /></td>
					</tr>


					<tr>
						<td><i class="glyphicon glyphicon-phone blue">
						</i> <font color="#585858"><strong>Telephone Portable Pediatre : </strong></font></td>
						<td><f:input path="telephonePortablePediatre" /></td>
						<td><f:errors path="telephonePortablePediatre"
							cssClass="errors" /></td>
						</tr>

						<tr>
							<td><i class="glyphicon glyphicon-tree-conifer blue">
							</i> <font color="#585858"><strong>Nombre Frères :</strong></font></td>
							<td><f:input path="nombreFreres" /></td>
							<td><f:errors path="nombreFreres" cssClass="errors" /></td>
						</tr>

						<tr>
							<td><i class="glyphicon glyphicon-tree-deciduous blue">
							</i> <font color="#585858"><strong>Nombre Soeurs : </strong></font></td>
							<td><f:input path="nombreSoeur" /></td>
							<td><f:errors path="nombreSoeur" cssClass="errors" /></td>
						</tr>


                            <!-- ajouter et afficher details 

								<tr>
									<td><input type="submit"
										value="Ajouter et afficher details" /></td>
									</tr>-->




								</table>

							</f:form></h3>
						</div>


						<!-- table Parent -->

						<div class="tab-pane" id="custom">
							<h3>


								<!-- Formulaire -->
								<legend>Veuillez Remplir le Formulaire Parent :</legend>

								<f:form modelAttribute="parent" action="ajouterParentEA" 
								method="post" enctype="multipart/form-data" id="parentForm">  <!--enctype="" pour le Upload on vas telecharger une photo  -->

								<table>
									<tr>
										<!--  <td>ID</td>--> 
										<td><f:input type="hidden" path="idPerson"/></td>
										<td><f:errors type="hidden" path="idPerson" cssClass="errors"/></td>
									</tr>




									<tr>
										<td><i class="glyphicon glyphicon-tag  green">
										</i> <font color="#585858"><strong>Nom : *</strong></font></td>
										<td><f:input path="nom"/></td>
										<td><f:errors path="nom" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-barcode  green">
										</i> <font color="#585858"><strong>Prenom : *</strong></font></td>
										<td><f:input path="prenom"/></td>
										<td><f:errors path="prenom" cssClass="errors"/></td>
									</tr>


									<tr>
										<td><i class="glyphicon glyphicon-camera green">
										</i> <font color="#585858"><strong>Photo: </strong></font></td>

										<c:if test="${parent.idPerson!=0}">
										<img src="photoParent?idParent=${parent.idPerson}" class="images_petit"/>
									</c:if>

									<td><input  type="file" name="filePar"/>
									</tr>



									<tr>
										<td><i class="glyphicon glyphicon-edit green">
										</i> <font color="#585858"><strong>Cin :</strong></font></td>
										<td><f:input path="cin"/></td>
										<td><f:errors path="cin" cssClass="errors"/></td>
									</tr>
									<tr>
										<td><i class="glyphicon glyphicon-usd green">
										</i> <font color="#585858"><strong>Profession :</strong></font></td>
										<td><f:input path="profession"/></td>
										<td><f:errors path="profession" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-home  green">
										</i> <font color="#585858"><strong>Adresse Domicile :</strong></font></td>
										<td><f:input path="adresseDomicile"/></td>
										<td><f:errors path="adresseDomicile" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-phone-alt  green">
										</i> <font color="#585858"><strong>Telephone Domicile :</strong></font></td>
										<td><f:input path="telephoneDomicile"/></td>
										<td><f:errors path="telephoneDomicile" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-phone  green">
										</i> <font color="#585858"><strong>Telephone Portable :</strong></font></td>
										<td><f:input path="telephonePortable"/></td>
										<td><f:errors path="telephonePortable" cssClass="errors"/></td>
									</tr>


									<tr>
										<td><i class="glyphicon glyphicon-envelope  green">
										</i> <font color="#585858"><strong>Email :</strong></font></td>
										<td><f:input path="email"/></td>
										<td><f:errors path="email" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-road  green">
										</i> <font color="#585858"><strong> Lieu de Travail :</strong></font></td>
										<td><f:input path="lieuTravail"/></td>
										<td><f:errors path="lieuTravail" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-earphone  green">
										</i> <font color="#585858"><strong>Telephone Travail :</strong></font></td>
										<td><f:input path="telephoneTravail"/></td>
										<td><f:errors path="telephoneTravail" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class=" glyphicon glyphicon-star  green">
										</i> <font color="#585858"><strong>Nom Utilisateur :</strong></font></td>
										<td><f:input path="nomUtilisateur"/></td>
										<td><f:errors path="nomUtilisateur" cssClass="errors"/></td>
									</tr>

									<tr>
										<td><i class=" glyphicon glyphicon-ban-circle  green">
										</i> <font color="#585858"><strong>Mot de Passe :</strong></font></td>
										<td><f:input path="motPasse"/></td>
										<td><f:errors path="motPasse" cssClass="errors"/></td>
									</tr>



									<tr>
										<td><i class=" glyphicon glyphicon-user  green">
										</i> <font color="#585858"><strong> Genre :</strong></font></td>
										<td>
											<f:radiobutton path="genre" value="Papa"/> Papa
											<f:radiobutton path="genre" value="Maman"/> Maman 
										</td>
									</tr>



       <!--     
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
            
       </tr>--> 
   </table>

</f:form>




</h3>

</div>


<!-- table Accompagnateur -->

<div class="tab-pane" id="messages">
	<h3><legend>Veuillez Remplir le Formulaire Accompagnateur :</legend>


		<f:form modelAttribute="accompagnateur" action="ajouterAccompagnateurEP" 
		method="post" enctype="multipart/form-data" id="accompForm">  <!--enctype="" pour le Upload on vas telecharger une photo  -->

		<table>
			<tr>
				<!--  <td>ID</td> -->
				<td><f:input type="hidden" path="idPerson"/></td>
				<td><f:errors type="hidden" path="idPerson" cssClass="errors"/></td>
			</tr>




			<tr>
				<td><i class="glyphicon glyphicon-tag  red">
				</i> <font color="#585858"><strong>Nom :</strong></font></td>
				<td><f:input path="nom"/></td>
				<td><f:errors path="nom" cssClass="errors"/></td>
			</tr>

			<tr>
				<td><i class="glyphicon glyphicon-barcode  red">
				</i> <font color="#585858"><strong>Prenom :</strong></font></td>
				<td><f:input path="prenom"/></td>
				<td><f:errors path="prenom" cssClass="errors"/></td>
			</tr>




			<tr>
				<td><i class="glyphicon glyphicon-camera red">
				</i> <font color="#585858"><strong> Photo :</strong></font></td>

				<c:if test="${accompagnateur.idPerson!=0}">
				<img src="photoAccomp?idAccompagnateur=${accompagnateur.idPerson}" class="images_petit"/>
			</c:if>

			<td><input  type="file" name="fileAcom"/>
			</tr>

			<tr>
				<td><i class="glyphicon glyphicon-edit red">
				</i> <font color="#585858"><strong>Cin :</strong></font></td>
				<td><f:input path="cin"/></td>
				<td><f:errors path="cin" cssClass="errors"/></td>
			</tr>

			<tr>
				<td><i class="glyphicon glyphicon-pencil  red">
				</i> <font color="#585858"><strong>Description :</strong></font></td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"/></td>
			</tr>

			<tr>
				<td><i class="glyphicon glyphicon-phone  red">
				</i> <font color="#585858"><strong>Tel.portable :</strong></font></td>
				<td><f:input path="telephonePortable"/></td>
				<td><f:errors path="telephonePortable" cssClass="errors"/></td>
			</tr>




		</table>

	</f:form>





</h3>

</div>


</div>



            </div>
            <button class="btn btn-danger" id="subbut">Ajouter</button>
        </div>
    </div>
 </div>
    







	
<!-- footer -->


	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>




</body>
</html>
