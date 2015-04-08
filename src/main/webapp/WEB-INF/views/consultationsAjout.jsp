<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">


</head>

<div id="formCond" class="cadre">

    <f:form modelAttribute="consultation" action="ajouterConsultation" method="post" >  

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
           <td>Taille Enfant</td>
           <td><f:input path="tailleEnfant"/></td>
           <td><f:errors path="tailleEnfant" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Poids Enfant</td>
            <td><f:input path="poidsEnfants"/></td>
           <td><f:errors  path="poidsEnfants" cssClass="errors"/>
           </tr>
           
           <tr>
           <td>description</td>
           <td><f:textarea path="description"/></td>
           <td><f:errors  path="description" cssClass="errors"/>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listCons" class="cadre" >
<c:if test="${not empty consultationAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${consultationAjoute.idConsultation}</td>
</tr>

<tr>
<td>DATE</td>
<td>${consultationAjoute.date}</td>
</tr>

<tr>
<td>TAILLE ENFANT</td>
<td>${consultationAjoute.tailleEnfant}</td>
</tr>

<tr>
<td>POIDS ENFANT</td>
<td>${consultationAjoute.poidsEnfants}</td>
</tr>

<tr>
<td>DESCRIPTION</td>
<td>${consultationAjoute.description}</td>
</tr>


</table>
</c:if>
</div>

