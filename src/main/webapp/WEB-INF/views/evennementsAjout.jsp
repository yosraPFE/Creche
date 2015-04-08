<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">


</head>

<div id="formEven" class="cadre">

    <f:form modelAttribute="evennement" action="ajouterEvennement" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idEvenement"/></td>
           <td><f:errors path="idEvenement" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nom</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Type</td>
           <td><f:input path="type"/></td>
           <td><f:errors path="type" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Fraix</td>
            <td><f:input path="fraix"/></td>
           <td><f:errors  path="fraix" cssClass="errors"/>
           </tr>
           
           <tr>
           <td>Date</td>
            <td><f:input type="datetime-local" path="date"/></td>
           <td><f:errors type="datetime-local" path="date" cssClass="errors"/>
           </tr>
          
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listEven" class="cadre" >
<c:if test="${not empty evennementAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${evennementAjoute.idEvenement}</td>
</tr>

<tr>
<td>NOM</td>
<td>${evennementAjoute.nom}</td>
</tr>

<tr>
<td>TYPE</td>
<td>${evennementAjoute.type}</td>
</tr>

<tr>
<td>FRAIX</td>
<td>${evennementAjoute.fraix}</td>
</tr>

<tr>
<td>DATE</td>
<td>${evennementAjoute.date}</td>
</tr>


</table>
</c:if>
</div>

