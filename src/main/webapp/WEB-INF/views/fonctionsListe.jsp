<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Fonctions</h>
<div id="tableFonctions" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>LABELLE</th>
</tr>
<c:forEach items="${fonctions}" var="fonc">
<tr>

<td>${fonc.idFonction}</td>
<td>${fonc.labelle}</td>


<td><a href="supprimerListeFonction?idFonction=${fonc.idFonction}">Supprimer<a/></td>
<td><a href="modifierListeFonction?idFonction=${fonc.idFonction}">Modifier<a/></td>
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
<c:if  test="${fonction.idFonction!=0}">
<div id="formFonc" class="cadre"> 
  
    <f:form modelAttribute="fonction" action="validerModificationFonct" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idFonction"/></td>
           <td><f:errors path="idFonction" cssClass="errors"/></td>
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
