<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Creches</h>
<div id="tableCreches" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>ADRESSE</th><th>SITE WEB</th><th>VILLE</th><th>TELEPHONE</th>
</tr>
<c:forEach items="${creches}" var="cre">
<tr>

<td>${cre.idCreche}</td>
<td><img src="photoCrech?idCreche=${cre.idCreche}" class="images_petit" /></td>
<td>${cre.nom}</td>
<td>${cre.adresse}</td>
<td>${cre.siteWeb}</td>
<td>${cre.ville}</td>
<td>${cre.telephone}</td>

<td><a href="supprimerListeCreche?idCreche=${cre.idCreche}">Supprimer<a/></td>
<td><a href="modifierListeCreche?idCreche=${cre.idCreche}">Modifier<a/></td>
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
<c:if  test="${creche.idCreche!=0}">
<div id="formCrech class="cadre"> 
  
    <f:form modelAttribute="creche" action="validerModificationCrech" method="post" enctype="multipart/form-data">  
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idCreche"/></td>
           <td><f:errors path="idCreche" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo:</td>
           <td>
           <c:if test="${creche.idCreche!=null}">
           <img src="photoCrech?idCreche=${creche.idCreche}" class="images_petit"/>
           
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
           <td>Adresse:</td>
           <td><f:input path="adresse"/></td>
           <td><f:errors path="adresse" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Site Web:</td>
           <td><f:input path="siteWeb"/></td>
           <td><f:errors path="siteWeb" cssClass="errors"/></td>
           </tr>
           
           
           
           <tr>
           <td>Ville:</td>
           <td><f:input path="ville"/></td>
           <td><f:errors path="ville" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone:</td>
           <td><f:input path="telephone"/></td>
           <td><f:errors path="telephone" cssClass="errors"/></td>
           </tr>
           
            
           
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>