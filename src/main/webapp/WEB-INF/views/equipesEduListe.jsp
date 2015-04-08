<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des EquipeEducatifs</h>
<div id="tableEquipeEducatifs" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>FONCTION</th><th>SEXE</th><th>ADRESSE</th><th>NOM UTILISATEUR</th><th>MOT PASSE</th>
</tr>
<c:forEach items="${equipeEducatifs}" var="EqEdu">
<tr>

<td>${EqEdu.idPerson}</td>
<td><img src="photoEqEdu?idEquipeEducatif=${EqEdu.idPerson}" class="images_petit" /></td>
<td>${EqEdu.nom}</td>
<td>${EqEdu.prenom}</td>
<td>${EqEdu.fonction.labelle}</td>
<td>${EqEdu.sexe}</td>
<td>${EqEdu.adresseDomicile}</td>
<td>${EqEdu.nomUtilisateur}</td>
<td>${EqEdu.motPasse}</td>

<td><a href="supprimerListeEquipeEducatif?idEquipeEducatif=${EqEdu.idPerson}">Supprimer<a/></td>
<td><a href="modifierListeEquipeEducatif?idEquipeEducatif=${EqEdu.idPerson}">Modifier<a/></td>
</tr>
</c:forEach>

</table>

<div>

<c:forEach begin="0" end="${nbrPages-1}" var="p">



<c:choose>

<c:when test="${p==page}">
<span>Page ${p}</span>
</c:when>
<c:otherwise>

<span>
<a href="indexPage?page=${p}">Page ${p}</a>
</span>

</c:otherwise>

</c:choose>
</c:forEach>

</div>



</div>
<c:if  test="${equipeEducatif.idPerson!=0}">
<div id="formEqEdu" class="cadre"> 
  
    <f:form modelAttribute="equipeEducatif" action="validerModificationEqEdu" method="post" enctype="multipart/form-data"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo:</td>
           <td>
           <c:if test="${equipeEducatif.idPerson!=null}">
           <img src="photoEqEdu?idEquipeEducatif=${equipeEducatif.idPerson}" class="images_petit"/>
           
           </c:if>
           </td>
           <td><input  type="file" name="file"/><br>
           <f:textarea   path="nomPhoto" readonly="true"/></td>
           </tr>
       
       
           <tr>
           <td>Nom:</td>
           <td><f:input path="nom"/></td>
          <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prenom:</td>
           <td><f:input path="prenom"/></td>
           <td><f:errors path="prenom" cssClass="errors"/></td>
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
           <td>Fonction</td>
           <td><f:select path="fonction.idFonction" items="${fonctions}" itemValue="idFonction" itemLabel="labelle"></f:select></td>
           <td><f:errors path="fonction.idFonction" items="${fonctions}" itemValue="idFonction" itemLabel="labelle" cssClass="errors"/></td>
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
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>