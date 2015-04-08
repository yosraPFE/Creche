<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formPar" class="cadre">

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
           <c:if test="${parent.idPerson!=0}">
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
           <td>Adresse Domicile</td>
           <td><f:input path="adresseDomicile"/></td>
           <td><f:errors path="adresseDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Domicile</td>
           <td><f:input path="telephoneDomicile"/></td>
           <td><f:errors path="telephoneDomicile" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Portable</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Email</td>
           <td><f:input path="email"/></td>
           <td><f:errors path="email" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Lieu de Travail</td>
           <td><f:input path="lieuTravail"/></td>
           <td><f:errors path="lieuTravail" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Travail</td>
           <td><f:input path="telephoneTravail"/></td>
           <td><f:errors path="telephoneTravail" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nom Utilisateur</td>
           <td><f:input path="nomUtilisateur"/></td>
           <td><f:errors path="nomUtilisateur" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Mot de Passe</td>
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
           <td><input type="submit" value="Ajouter et afficher details"/></td>
            
           </tr>
      </table>
  
    </f:form>
</BODY>
</div>
<div id="listParents" class="cadre" >
<c:if test="${not empty parentAjoute}">

<table class="tab1">


<tr>
<td>ID</td>
<td>${parentAjoute.idPerson}</td>
</tr>

<tr>
<td>PHOTO</td>
<td><img src="photoParent?idParent=${parentAjoute.idPerson}" class="images_petit" />

<textarea rows="" cols="">${parentAjoute.nomPhoto}</textarea>
</td>
</tr>

<tr>
<td>NOM</td>
<td>${parentAjoute.nom}</td>
</tr>



<tr>
<td>PRENOM</td>
<td>${parentAjoute.prenom}</td>
</tr>

<tr>
<td>CIN</td>
<td>${parentAjoute.cin}</td>
</tr>

<tr>
<td>PROFESSION</td>
<td>${parentAjoute.profession}</td>
</tr>

<tr>
<td>ADRESSE DOMICILE</td>
<td>${parentAjoute.adresseDomicile}</td>
</tr>


<tr>
<td>TEL.DOMICILE</td>
<td>${parentAjoute.telephoneDomicile}</td>
</tr>

<tr>
<td>TEL.PORTABLE</td>
<td>${parentAjoute.telephonePortable}</td>
</tr>


<tr>
<td>EMAIL</td>
<td>${parentAjoute.email}</td>
</tr>

<tr>
<td>LIEU TRAVAIL</td>
<td>${parentAjoute.lieuTravail}</td>
</tr>

<tr>
<td>TEL.TRAVAIL</td>
<td>${parentAjoute.telephoneTravail}</td>
</tr>


<tr>
<td>NOM UTILISATEUR</td>
<td>${parentAjoute.nomUtilisateur}</td>
</tr>


<tr>
<td>MOT PASSE</td>
<td>${parentAjoute.motPasse}</td>
</tr>

<tr>
<td>GENRE</td>
<td>${parentAjoute.genre}</td>
</tr>


</table>
</c:if>
</div>