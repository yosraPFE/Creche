<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">


</head>

<div id="formIns" class="cadre">

    <f:form modelAttribute="inscription" action="ajouterInscription" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idinscription"/></td>
           <td><f:errors path="idinscription" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Annee</td>
           <td><f:input path="annee"/></td>
           <td><f:errors path="annee" cssClass="errors"/></td>
           </tr>
           
           
           
          
<fmt:formatDate value="<%= new java.util.Date()%>" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
			
	
           <f:input type="hidden" path="dateInscription" value="${myDate}" />
           <f:errors type="hidden" path="dateInscription" cssClass="errors"/>
           
           
           <tr>
           <td>Tarif Inscription</td>
           <td><f:input path="tarifInscription"/></td>
           <td><f:errors path="tarifInscription" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Remise</td>
            <td><f:input path="remise"/></td>
           <td><f:errors  path="remise" cssClass="errors"/>
           </tr>
           
           
          
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listIns" class="cadre" >
<c:if test="${not empty inscriptionAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${inscriptionAjoute.idinscription}</td>
</tr>

<tr>
<td>ANNEE</td>
<td>${inscriptionAjoute.annee}</td>
</tr>

<tr>
<td>DATE INSCRIPTION</td>
<td>${inscriptionAjoute.dateInscription}</td>
</tr>

<tr>
<td>TARIF INSCRIPTION</td>
<td>${inscriptionAjoute.tarifInscription}</td>
</tr>

<tr>
<td>REMISE</td>
<td>${inscriptionAjoute.remise}</td>
</tr>


</table>
</c:if>
</div>

