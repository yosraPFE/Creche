<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formEqSan" class="cadre">

    <f:form modelAttribute="equipeSanitaire" action="ajouterEquipeSanitaire" method="post" enctype="multipart/form-data"> 

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Photo</td>
           <td>
           <c:if test="${equipeSanitaire.idPerson!=0}">
           <img src="photoEqSan?idEquipeSanitaire=${equipeSanitaire.idPerson}" class="images_petit"/>
           </c:if>
           </td>
           <td><input  type="file" name="file"/></td>
           </tr>
       
       
           <tr>
           <td>Nom</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Fonction</td>
           <td><f:select path="fonction.idFonction" items="${fonctions}" itemValue="idFonction" itemLabel="labelle"></f:select></td>
           <td><f:errors path="fonction.idFonction" items="${fonctions}" itemValue="idFonction" itemLabel="labelle" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prenom</td>
           <td><f:input path="prenom"/></td>
           <td><f:errors path="prenom" cssClass="errors"/></td>
           </tr>
           
          
           <tr>
           <td>Date de Naissance:</td>
           <td><f:input type="date" path="dateNaissance"/></td>
           <td><f:errors path="dateNaissance" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Lieu de Naissance</td>
           <td><f:input path="lieuNaissance"/></td>
           <td><f:errors path="lieuNaissance" cssClass="errors"/></td>
           </tr>
           
           
           
           
           <tr>
           <td>Sexe</td>
           <td>
           Homme <f:radiobutton path="sexe" value="Homme"/>
           Femme <f:radiobutton path="sexe" value="Femme"/>
           </td>
           </tr>
           
           
           
           <tr>
           <td>Adresse:</td>
           <td><f:input path="adresseDomicile"/></td>
           <td><f:errors path="adresseDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nom Utilisateur:</td>
           <td><f:input path="nomUtilisateur"/></td>
           <td><f:errors path="nomUtilisateur" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Mot de Passe:</td>
           <td><f:input path="motPasse"/></td>
           <td><f:errors path="motPasse" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listeqSan" class="cadre" >
<c:if test="${not empty equipeSanitaireAjoute }">

<table class="tab1">

<tr>
<td>ID</td>
<td>${equipeSanitaireAjoute.idPerson}</td>
</tr>
<tr>
<td>PHOTO</td>
<td><img src="photoEqSan?idEquipeSanitaire=${equipeSanitaireAjoute.idPerson}" class="images_petit" />

<textarea rows="" cols="">${equipeSanitaireAjoute.nomPhoto}</textarea>
</td>
</tr>

<tr>
<td>NOM</td>
<td>${equipeSanitaireAjoute.nom}</td>
</tr>

<tr>
<td>PRENOM</td>
<td>${equipeSanitaireAjoute.prenom}</td>
</tr>

<tr>
<td>FONCTION</td>
<td>${equipeSanitaireAjoute.fonction.labelle}</td>
</tr>

<tr>
<td>DATE NAISSANCE</td>
<td>${equipeSanitaireAjoute.dateNaissance}</td>
</tr>

<tr>
<td>LIEU NAISSANCE</td>
<td>${equipeSanitaireAjoute.lieuNaissance}</td>
</tr>

<tr>
<td>SEXE</td>
<td>${equipeSanitaireAjoute.sexe}</td>
</tr>


<tr>
<td>NOM UTILISATEUR</td>
<td>${equipeSanitaireAjoute.nomUtilisateur}</td>
</tr>


<tr>
<td>MOT PASSE</td>
<td>${equipeSanitaireAjoute.motPasse}</td>
</tr>

</table>
</c:if>
</div>
