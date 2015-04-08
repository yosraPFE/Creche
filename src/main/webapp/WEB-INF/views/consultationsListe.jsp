<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Consultations</h>
<div id="tableConsultation" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>DATE</th><th>TAILLE ENFANT</th><th>POIDS ENFANT</th><th>DESCRIPTION</th>
</tr>
<c:forEach items="${consultations}" var="cons">
<tr>

<td>${cons.idConsultation}</td>
<td>${cons.date}</td>
<td>${cons.tailleEnfant}</td>
<td>${cons.poidsEnfants}</td>
<td>${cons.description}</td>


<td><a href="supprimerListeConsultation?idConsultation=${cons.idConsultation}">Supprimer<a/></td>
<td><a href="modifierListeConsultation?idConsultation=${cons.idConsultation}">Modifier<a/></td>
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
<c:if  test="${consultation.idConsultation!=0}">
<div id="formCons" class="cadre"> 
  
    <f:form modelAttribute="consultation" action="validerModificationCons" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idConsultation"/></td>
           <td><f:errors path="idConsultation" cssClass="errors"/></td>
           </tr>
           
           <fmt:formatDate value="<%= new java.util.Date()%>" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
			
	
           <f:input type="hidden" path="date" value="${myDate}" />
           <f:errors type="hidden" path="date" cssClass="errors"/>
          
           
       
           <tr>
           <td>Taille Enfant:</td>
           <td><f:input path="tailleEnfant"/></td>
           <td><f:errors path="tailleEnfant" cssClass="errors"/></td>
           </tr>
           
          
           <tr>
           <td>Poids Enfant:</td>
           <td><f:input path="poidsEnfants"/></td>
           <td><f:errors path="poidsEnfants" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Description</td>
            <td><f:input  path="description"/></td>
           <td><f:errors path="description" cssClass="errors"/>
           </tr>
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
