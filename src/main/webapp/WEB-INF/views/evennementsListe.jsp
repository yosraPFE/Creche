<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Evennements</h>
<div id="tableEvennement" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>NOM</th><th>TYPE</th><th>FRAIX</th><th>DATE</th>
</tr>
<c:forEach items="${evennements}" var="even">
<tr>

<td>${even.idEvenement}</td>
<td>${even.nom}</td>
<td>${even.type}</td>
<td>${even.fraix}</td>
<td>${even.date}</td>


<td><a href="supprimerListeEvennement?idEvennement=${even.idEvenement}">Supprimer<a/></td>
<td><a href="modifierListeEvennement?idEvennement=${even.idEvenement}">Modifier<a/></td>
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
<c:if  test="${evennement.idEvenement!=0}">
<div id="formEven" class="cadre"> 
  
    <f:form modelAttribute="evennement" action="validerModificationEven" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idEvenement"/></td>
           <td><f:errors path="idEvenement" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Nom:</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Type:</td>
           <td><f:input path="type"/></td>
           <td><f:errors path="type" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Fraix:</td>
           <td><f:input path="fraix"/></td>
           <td><f:errors path="fraix" cssClass="errors"/></td>
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
