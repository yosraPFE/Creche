<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formMater" class="cadre">

    <f:form modelAttribute="materiel" action="ajouterMateriel" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idMateriel"/></td>
           <td><f:errors path="idMateriel" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Designation</td>
           <td><f:textarea path="designation"/></td>
           <td><f:errors path="designation" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Description</td>
           <td><f:textarea path="description"/></td>
           <td><f:errors path="description" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prix</td>
           <td><f:input path="prix"/></td>
           <td><f:errors path="prix" cssClass="errors"/></td>
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
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listMateriel" class="cadre" >
<c:if test="${not empty materielAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${materielAjoute.idMateriel}</td>
</tr>

<tr>
<td>DESIGNATION</td>
<td>
<textarea rows="" cols="">${materielAjoute.designation}</textarea>
</td>
</tr>

<tr>
<td>DESCRIPTION</td>
<td>
<textarea rows="" cols="">${materielAjoute.description}</textarea>
</td>
</tr>



<tr>
<td>PRIX</td>
<td>${materielAjoute.prix}</td>
</tr>

<tr>
<td>TYPE</td>
<td>${materielAjoute.typeMateriel.labelle}</td>
</tr>

<tr>
<td>STOCK</td>
<td>${materielAjoute.stock.quantite}</td>
</tr>


</table>
</c:if>
</div>

