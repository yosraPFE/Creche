<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des TypesMateriels</h>
<div id="tableTypeMateriels" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>LABELLE</th>
</tr>
<c:forEach items="${typeMateriels}" var="typM">
<tr>

<td>${typM.idTypeMateriel}</td>
<td>${typM.labelle}</td>


<td><a href="supprimerListeTypeMateriels?idTypeMateriels=${typM.idTypeMateriel}">Supprimer<a/></td>
<td><a href="modifierListeTypeMateriels?idTypeMateriels=${typM.idTypeMateriel}">Modifier<a/></td>
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
<c:if  test="${typeMateriel.idTypeMateriel!=0}">
<div id="formTypM" class="cadre"> 
  
    <f:form modelAttribute="typeMateriel" action="validerModificationtypeMat" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idTypeMateriel"/></td>
           <td><f:errors path="idTypeMateriel" cssClass="errors"/></td>
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
