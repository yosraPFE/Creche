<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formAccomp" class="cadre">

    <f:form modelAttribute="accompagnateur" action="ajouterAccompagnateur" method="post" enctype="multipart/form-data">  <!--enctype="" pour le Upload on vas telecharger une photo  -->

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo</td>
           <td>
           <c:if test="${accompagnateur.idPerson!=null}">
           <img src="photoAccomp?idAccompagnateur=${accompagnateur.idPerson}" class="images_petit"/>
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
           <td>Description</td>
           <td><f:textarea path="description"/></td>
           <td><f:errors path="description" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.portable</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>
<c:if test="${not empty accompagnateurs }">
<div id="" class="cadre" >

<table class="tab1">

<tr>
<td>ID</td>
<td>${accompagnateurs.idPerson}</td>
</tr>
<tr>
<td>PHOTO</td>
<td><img src="photoAccomp?idAccompagnateur=${accompagnateurs.idPerson}" class="images_petit" /></td>
</tr>
<tr>
<td>NOM</td>
<td>${accompagnateurs.nom}</td>
</tr>

<tr>
<td>PRENOM</td>
<td>${accompagnateurs.prenom}</td>
</tr>

<tr>
<td>CIN</td>
<td>${accompagnateurs.cin}</td>
</tr>

<tr>
<td>DESCRIPTION</td>
<td>${accompagnateurs.description}</td>
</tr>

<tr>
<td>TEL.PORTABLE</td>
<td>${accompagnateurs.telephonePortable}</td>
</tr>

</table>
</div>
</c:if>