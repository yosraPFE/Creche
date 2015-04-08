<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formCrech" class="cadre">

    <f:form modelAttribute="creche" action="ajouterCreche" method="post" enctype="multipart/form-data">  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idCreche"/></td>
           <td><f:errors path="idCreche" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Photo</td>
           <td>
           <c:if test="${creche.idCreche!=0}">
           <img src="photoCrech?idCreche=${creche.idCreche}" class="images_petit"/>
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
           <td>Adresse</td>
           <td><f:input path="adresse"/></td>
           <td><f:errors path="adresse" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Site Web</td>
           <td><f:input path="siteWeb"/></td>
           <td><f:errors path="siteWeb" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td>Ville</td>
           <td><f:input path="ville"/></td>
           <td><f:errors path="ville" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone</td>
           <td><f:input path="telephone"/></td>
           <td><f:errors path="telephone" cssClass="errors"/></td>
           </tr>
           
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listcrech" class="cadre" >
<c:if test="${not empty crecheAjoute }">

<table class="tab1">

<tr>
<td>ID</td>
<td>${crecheAjoute.idCreche}</td>
</tr>
<tr>
<td>PHOTO</td>
<td><img src="photoCrech?idCreche=${crecheAjoute.idCreche}" class="images_petit" />

<textarea rows="" cols="">${crecheAjoute.nomPhoto}</textarea>
</td>
</tr>

<tr>
<td>NOM</td>
<td>${crecheAjoute.nom}</td>
</tr>

<tr>
<td>ADRESSE</td>
<td>${crecheAjoute.adresse}</td>
</tr>

<tr>
<td>SITE WEB</td>
<td>${crecheAjoute.siteWeb}</td>
</tr>

<tr>
<td>VILLE</td>
<td>${crecheAjoute.ville}</td>
</tr>

<tr>
<td>TELEPHONE</td>
<td>${crecheAjoute.telephone}</td>
</tr>

</table>
</c:if>
</div>
