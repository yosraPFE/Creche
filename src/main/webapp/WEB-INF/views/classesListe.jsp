<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Classes</h>
<div id="tableClasses" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>NOM</th><th>NOMBRE PLACES</th><th>CRECHE</th>
</tr>
<c:forEach items="${classes}" var="clas">
<tr>

<td>${clas.idClass}</td>
<td>${clas.nom}</td>
<td>${clas.nombrePlaces}</td>
<td>${clas.creche.nom}</td>

<td><a href="supprimerListeClasse?idClasse=${clas.idClass}">Supprimer<a/></td>
<td><a href="modifierListeClasse?idClasse=${clas.idClass}">Modifier<a/></td>
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
<c:if  test="${classe.idClass!=0}">
<div id="formClass" class="cadre"> 
  
    <f:form modelAttribute="classe" action="validerModificationClas" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idClass"/></td>
           <td><f:errors path="idClass" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Nom:</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Creche</td>
           <td><f:select path="creche.idCreche" items="${creches}" itemValue="idCreche" itemLabel="nom"></f:select></td>
           <td><f:errors path="creche.idCreche" items="${creches}" itemValue="idCreche" itemLabel="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nombre Places:</td>
           <td><f:input path="nombrePlaces"/></td>
           <td><f:errors path="nombrePlaces" cssClass="errors"/></td>
           </tr>
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
