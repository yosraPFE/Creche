<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des GenrePlannings</h>
<div id="tableGenrePlannings" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>LABELLE</th>
</tr>
<c:forEach items="${genrePlannings}" var="grp">
<tr>

<td>${grp.idGenrePlanning}</td>
<td>${grp.labelle}</td>

<td><a href="supprimerListeGenrePlanning?idGenrePlanning=${grp.idGenrePlanning}">Supprimer<a/></td>
<td><a href="modifierListeGenrePlanning?idGenrePlanning=${grp.idGenrePlanning}">Modifier<a/></td>
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
<c:if  test="${genrePlanning.idGenrePlanning!=0}">
<div id="formGrPl" class="cadre"> 
  
    <f:form modelAttribute="genrePlanning" action="validerModificationGenrePla" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idGenrePlanning"/></td>
           <td><f:errors path="idGenrePlanning" cssClass="errors"/></td>
           </tr>
         
           <tr>
           <td>Labelle:</td>
           <td><f:input path="labelle"/></td>
           <td><f:errors path="labelle" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>