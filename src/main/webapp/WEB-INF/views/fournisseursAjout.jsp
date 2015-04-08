<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formFour" class="cadre">

    <f:form modelAttribute="fournisseur" action="ajouterFournisseur" method="post" enctype="multipart/form-data"> 

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Photo</td>
           <td>
           <c:if test="${fournisseur.idPerson!=0}">
           <img src="photoFour?idFournisseur=${fournisseur.idPerson}" class="images_petit"/>
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
           <td>Adresse Societé:</td>
           <td><f:input path="adresseSociete"/></td>
           <td><f:errors path="adresseSociete" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.Societe</td>
           <td><f:input path="telephoneSociete"/></td>
           <td><f:errors path="telephoneSociete" cssClass="errors"/></td>
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
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listfour" class="cadre" >
<c:if test="${not empty fournisseurAjoute }">

<table class="tab1">

<tr>
<td>ID</td>
<td>${fournisseurAjoute.idPerson}</td>
</tr>
<tr>
<td>PHOTO</td>
<td><img src="photoFour?idFournisseur=${fournisseurAjoute.idPerson}" class="images_petit" />

<textarea rows="" cols="">${fournisseurAjoute.nomPhoto}</textarea>
</td>
</tr>

<tr>
<td>NOM</td>
<td>${fournisseurAjoute.nom}</td>
</tr>

<tr>
<td>PRENOM</td>
<td>${fournisseurAjoute.prenom}</td>
</tr>

<tr>
<td>CIN</td>
<td>${fournisseurAjoute.cin}</td>
</tr>

<tr>
<td>ADRESSE SOCIETE</td>
<td>${fournisseurAjoute.adresseSociete}</td>
</tr>

<tr>
<td>TEL.SOCIETE</td>
<td>${fournisseurAjoute.telephoneSociete}</td>
</tr>


<tr>
<td>TEL.PORTABLE</td>
<td>${fournisseurAjoute.telephonePortable}</td>
</tr>


<tr>
<td>EMAIL</td>
<td>${fournisseurAjoute.email}</td>
</tr>

</table>
</c:if>
</div>

