<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">


</head>

<div id="formGenPl" class="cadre">

    <f:form modelAttribute="genrePlanning" action="ajouterGenrePlann" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idGenrePlanning"/></td>
           <td><f:errors path="idGenrePlanning" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Labelle</td>
           <td><f:input path="labelle"/></td>
           <td><f:errors path="labelle" cssClass="errors"/></td>
           </tr>
           
         
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listGenPl" class="cadre" >
<c:if test="${not empty genrePlanningAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${genrePlanningAjoute.idGenrePlanning}</td>
</tr>

<tr>
<td>LABELLE</td>
<td>${genrePlanningAjoute.labelle}</td>
</tr>



</table>
</c:if>
</div>

