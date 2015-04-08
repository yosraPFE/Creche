<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Parents</h>
<div id="tableParents" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>PROFESSION</th><th>GENRE</th>
</tr>
<c:forEach items="${parents}" var="pa">
<tr>

<td>${pa.idPerson}</td>
<td><img src="photoPar?idParent=${pa.idPerson}" class="images_petit" /></td>
<td>${pa.nom}</td>
<td>${pa.prenom}</td>
<td>${pa.profession}</td>
<td>${pa.genre}</td>


<td><a href="supprimerListeParent?idParent=${pa.idPerson}">Supprimer<a/></td>
<td><a href="modifierListeParent?idParent=${pa.idPerson}">Modifier<a/></td>
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
<c:if  test="${parent.idPerson!=0}">
<div id="formParen" class="cadre"> 
  
    <f:form modelAttribute="parent" action="validerModificationParent" method="post" enctype="multipart/form-data">  
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo:</td>
           <td>
           <c:if test="${parent.idPerson!=null}">
           <img src="photoPar?idParent=${parent.idPerson}" class="images_petit"/>
           
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
           <td>Cin</td>
           <td><f:input path="cin"/></td>
           <td><f:errors path="cin" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Profession:</td>
           <td><f:input path="profession"/></td>
           <td><f:errors path="profession" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Adresse Domicile:</td>
           <td><f:input path="adresseDomicile"/></td>
           <td><f:errors path="adresseDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Domicile:</td>
           <td><f:input path="telephoneDomicile"/></td>
           <td><f:errors path="telephoneDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Portable:</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Email:</td>
           <td><f:input path="email"/></td>
           <td><f:errors path="email" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Lieu de Travail:</td>
           <td><f:input path="lieuTravail"/></td>
           <td><f:errors path="lieuTravail" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Telephone de Travail:</td>
           <td><f:input path="telephoneTravail"/></td>
           <td><f:errors path="telephoneTravail" cssClass="errors"/></td>
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
           <td>Genre</td>
           <td>
           Papa <f:radiobutton path="genre" value="Papa"/>
           Maman <f:radiobutton path="genre" value="Maman"/>
           </td>
           </tr>
           
           
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>