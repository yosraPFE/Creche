<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formStock" class="cadre">

    <f:form modelAttribute="stock" action="ajouterStock" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idStock"/></td>
           <td><f:errors path="idStock" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Quantité</td>
           <td><f:input path="quantite"/></td>
           <td><f:errors path="quantite" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listStoc" class="cadre" >
<c:if test="${not empty stockAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${stockAjoute.idStock}</td>
</tr>

<tr>
<td>QUANTITE</td>
<td>${stockAjoute.quantite}</td>
</tr>



</table>
</c:if>
</div>

