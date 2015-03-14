<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>s

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formEnf" class="cadre">

    <f:form modelAttribute="parent" action="ajouterParent" method="post" enctype="multipart/form-data">  <!--enctype="" pour le Upload on vas telecharger une photo  -->

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Photo</td>
           <td>
           <c:if test="${parent.idPerson!=null}">
           <img src="photoParent?idParent=${parent.idPerson}" class="images_petit"/>
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
           <td>Prenom</td>
           <td><f:input path="prenom"/></td>
           <td><f:errors path="prenom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Cin</td>
           <td><f:input path="cin"/></td>
           <td><f:errors path="cin" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Profession</td>
           <td><f:input path="profession"/></td>
           <td><f:errors path="profession" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.Domicile</td>
           <td><f:input path="telephoneDomicile"/></td>
           <td><f:errors path="telephoneDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Lieu De Travail</td>
           <td><f:input path="lieuTravail"/></td>
           <td><f:errors path="lieuTravail" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Telephone De Travail</td>
           <td><f:input path="telephoneTravail"/></td>
           <td><f:errors path="telephoneTravail" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nom Utilisateur</td>
           <td><f:input path="nomUtilisateur"/></td>
           <td><f:errors path="nomUtilisateur" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Mot Passe</td>
           <td><f:input path="motPasse"/></td>
           <td><f:errors path="motPasse" cssClass="errors"/></td>
           </tr>
           
           
             
           <tr>
           <td>Genre</td>
           <td><f:select path="genre.idGenre" items="${genres}" itemValue="idGenre" itemLabel="labelle"></f:select></td>
           <td><f:errors path="motPasse" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Adresse</td>
           <td><f:input path="adresseDomicile"/></td>
           <td><f:errors path="adresseDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.Portable</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Email</td>
           <td><f:input path="email"/></td>
           <td><f:errors path="email" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td><input type="submit" value="Ajouter"/></td>
            
           </tr>
      </table>
  
    </f:form>

</div>
<div id="tableParents" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>NOM D'UTILISATEUR</th><th>MOT DE PASSE</th><th>GENRE</th><th>ADRESSE</th><th>TEL.PORTABLE</th><th>EMAIL</th>
</tr>
<c:forEach items="${parents}" var="par">
<tr>

<td>${par.idPerson}</td>
<td><img src="photoParent?idParent=${parent.idPerson}" class="images_petit"/></td>
<td>${par.nom}</td>
<td>${par.prenom}</td>
<td>${par.nomUtilisateur}</td>
<td>${par.motPasse}</td>
<td>${par.genre.labelle}</td>
<td>${par.adresseDomicile}</td>
<td>${par.telephonePortable}</td>
<td>${par.email}</td>
<td><a href="supprimerParent?idParent=${par.idPerson}">Supprimer l'Ajout<a/></td>
<td><a href="modifierParent?idParent=${par.idPerson}">Modifier l'Ajout<a/></td>

</tr>
</c:forEach>

</table>
</div>