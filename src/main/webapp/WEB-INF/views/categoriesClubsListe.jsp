<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des CategorieClubs</h>
<div id="tableCategorieClub" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>LABELLE</th><th>PRIX</th><th>DATE</th>
</tr>
<c:forEach items="${CategorieClubs}" var="cat">
<tr>

<td>${cat.idCateg}</td>
<td>${cat.labelle}</td>
<td>${cat.prix}</td>
<td>${cat.date}</td>


<td><a href="supprimerListeCategorieClub?idCategorieClub=${cat.idCateg}">Supprimer<a/></td>
<td><a href="modifierListeCategorieClub?idCategorieClub=${cat.idCateg}">Modifier<a/></td>
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
<c:if  test="${categorieClub.idCateg!=0}">
<div id="formCateg" class="cadre"> 
  
    <f:form modelAttribute="categorieClub" action="validerModificationCateg" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idCateg"/></td>
           <td><f:errors path="idCateg" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Labelle:</td>
           <td><f:input path="labelle"/></td>
           <td><f:errors path="labelle" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prix:</td>
           <td><f:input path="prix"/></td>
           <td><f:errors path="prix" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Date</td>
            <td><f:input type="datetime-local" path="date"/></td>
           <td><f:errors type="datetime-local" path="date" cssClass="errors"/>
           </tr>
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
