<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">


</head>

<div id="formCateg" class="cadre">

    <f:form modelAttribute="categorieClub" action="ajouterCategorieClub" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idCateg"/></td>
           <td><f:errors path="idCateg" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Labelle</td>
           <td><f:input path="labelle"/></td>
           <td><f:errors path="labelle" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Prix</td>
           <td><f:input path="prix"/></td>
           <td><f:errors path="prix" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Date</td>
            <td><f:input type="datetime-local" path="date"/></td>
           <td><f:errors type="datetime-local" path="date" cssClass="errors"/>
           </tr>
          
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listCateg" class="cadre" >
<c:if test="${not empty categorieClubAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${categorieClubAjoute.idCateg}</td>
</tr>

<tr>
<td>LABELLE</td>
<td>${categorieClubAjoute.labelle}</td>
</tr>

<tr>
<td>PRIX</td>
<td>${categorieClubAjoute.prix}</td>
</tr>

<tr>
<td>DATE</td>
<td>${categorieClubAjoute.date}</td>
</tr>


</table>
</c:if>
</div>

