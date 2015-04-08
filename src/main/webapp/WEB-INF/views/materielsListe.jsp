<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Materiels</h>
<div id="tableMateriels" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>DESIGNATION</th><th>DESCRIPTION</th><th>PRIX</th><th>TYPE</th><th>STOCK</th>
</tr>
<c:forEach items="${materiels}" var="m">
<tr>

<td>${m.idMateriel}</td>
<td>${m.designation}</td>
<td>${m.description}</td>
<td>${m.prix}</td>
<td>${m.typeMateriel.labelle}</td>
<td>${m.stock.quantite}</td>

<td><a href="supprimerListeMateriels?idMat=${m.idMateriel}">Supprimer<a/></td>
<td><a href="modifierListeMateriels?idMat=${m.idMateriel}">Modifier<a/></td>
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
<c:if  test="${materiel.idMateriel!=0}">
<div id="formMater" class="cadre"> 
  
    <f:form modelAttribute="materiel" action="validerModificationMateriel" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idMateriel"/></td>
           <td><f:errors path="idMateriel" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Designation:</td>
           <td><f:textarea path="designation"/></td>
           <td><f:errors path="designation" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Description:</td>
           <td><f:textarea path="description"/></td>
           <td><f:errors path="description" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Type</td>
           <td><f:select path="typeMateriel.idTypeMateriel" items="${typeMateriels}" itemValue="idTypeMateriel" itemLabel="labelle"></f:select></td>
           <td><f:errors path="typeMateriel.idTypeMateriel" items="${typeMateriels}" itemValue="idTypeMateriel" itemLabel="labelle" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Stock</td>
           <td><f:select path="stock.idStock" items="${stocks}" itemValue="idStock" itemLabel="quantite"></f:select></td>
           <td><f:errors path="stock.idStock" items="${stocks}" itemValue="idStock" itemLabel="quantite" cssClass="errors"/></td>
           </tr>
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
