<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Accompagnteurs</h>
<div id="tableAccompagnateurs" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>CIN</th><th>DESCRIPTION</th><th>TEL.PORTABLE</th>
</tr>
<c:forEach items="${accompagnateurs}" var="acc">
<tr>

<td>${acc.idPerson}</td>
<td><img src="photoAccomp?idAccompagnateur=${acc.idPerson}" class="images_petit" /></td>
<td>${acc.nom}</td>
<td>${acc.prenom}</td>
<td>${acc.cin}</td>
<td>${acc.description}</td>
<td>${acc.telephonePortable}</td>

<td><a href="supprimerListeAccompagnateur?idAccompagnateur=${acc.idPerson}">Supprimer<a/></td>
<td><a href="modifierListeAccompagnateur?idAccompagnateur=${acc.idPerson}">Modifier<a/></td>
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
<c:if  test="${accompagnateur.idPerson!=0}">
<div id="formAccomp" class="cadre"> 
  
    <f:form modelAttribute="accompagnateur" action="validerModificationAccomp" method="post" enctype="multipart/form-data">  <!--enctype="" pour le Upload on vas telecharger une photo  -->
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo:</td>
           <td>
           <c:if test="${accompagnateur.idPerson!=null}">
           <img src="photoAccomp?idAccompagnateur=${accompagnateur.idPerson}" class="images_petit"/>
           
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
           <td>Cin:</td>
           <td><f:input path="cin"/></td>
           <td><f:errors path="cin" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Description:</td>
           <td><f:textarea path="description"/></td>
           <td><f:errors path="description" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.portable:</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>