<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formPlanningHor" class="cadre">

    <f:form modelAttribute="planningHorraire" action="ajouterPlanningHorraire" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPlanning"/></td>
           <td><f:errors path="idPlanning" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Prix</td>
           <td><f:input path="prix"/></td>
           <td><f:errors path="prix" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Genre</td>
           <td><f:select path="genresPlannings.idGenrePlanning" items="${genrePlannings}" itemValue="idGenrePlanning" itemLabel="labelle"></f:select></td>
           <td><f:errors path="genresPlannings.idGenrePlanning" items="${genrePlannings}" itemValue="idGenrePlanning" itemLabel="labelle" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listPlanningHor" class="cadre" >
<c:if test="${not empty planningHorraireAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${planningHorraireAjoute.idPlanning}</td>
</tr>

<tr>
<td>PRIX</td>
<td>${planningHorraireAjoute.prix}</td>
</tr>

<tr>
<td>GENRE PLANNINGS</td>
<td>${planningHorraireAjoute.genresPlannings.labelle}</td>
</tr>


</table>
</c:if>
</div>

