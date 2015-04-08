<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Stocks</h>
<div id="tableStock" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>QUANTITE</th>
</tr>
<c:forEach items="${stocks}" var="st">
<tr>

<td>${st.idStock}</td>
<td>${st.quantite}</td>


<td><a href="supprimerListeStock?idStock=${st.idStock}">Supprimer<a/></td>
<td><a href="modifierListeStock?idStock=${st.idStock}">Modifier<a/></td>
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
<c:if  test="${stock.idStock!=0}">
<div id="formSto" class="cadre"> 
  
    <f:form modelAttribute="stock" action="validerModificationStoc" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idStock"/></td>
           <td><f:errors path="idStock" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Quantité:</td>
           <td><f:input path="quantite"/></td>
          <td><f:errors path="quantite" cssClass="errors"/></td>
           </tr>
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
