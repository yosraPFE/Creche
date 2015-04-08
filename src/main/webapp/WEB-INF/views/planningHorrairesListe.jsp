<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Plannings Horraires</h>
<div id="tablePlannings" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PRIX</th><th>GENRES</th>
</tr>
<c:forEach items="${planningHorraires}" var="plHo">
<tr>

<td>${plHo.idPlanning}</td>
<td>${plHo.prix}</td>
<td>${plHo.genresPlannings.labelle}</td>

<td><a href="supprimerListePlanningHorraires?idPlanningHo=${plHo.idPlanning}">Supprimer<a/></td>
<td><a href="modifierListePlanningHorraires?idPlanningHo=${plHo.idPlanning}">Modifier<a/></td>
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
<c:if  test="${planningHorraire.idPlanning!=0}">
<div id="formPlanHo" class="cadre"> 
  
    <f:form modelAttribute="planningHorraire" action="validerModificationPlanHor" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idPlanning"/></td>
           <td><f:errors path="idPlanning" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Prix:</td>
           <td><f:input path="prix"/></td>
           <td><f:errors path="prix" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Genre</td>
           <td><f:select path="genresPlannings.idGenrePlanning" items="${genrePlannings}" itemValue="idGenrePlanning" itemLabel="labelle"></f:select></td>
           <td><f:errors path="genresPlannings.idGenrePlanning" items="${genrePlannings}" itemValue="idGenrePlanning" itemLabel="labelle" cssClass="errors"/></td>
           </tr>
           
           
           
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
