<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formClas" class="cadre">

    <f:form modelAttribute="classe" action="ajouterClasse" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idClass"/></td>
           <td><f:errors path="idClass" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Nom</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Creche</td>
           <td><f:select path="creche.idCreche" items="${creches}" itemValue="idCreche" itemLabel="nom"></f:select></td>
           <td><f:errors path="creche.idCreche" items="${creches}" itemValue="idCreche" itemLabel="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nombre Places</td>
           <td><f:input path="nombrePlaces"/></td>
           <td><f:errors path="nombrePlaces" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listClass" class="cadre" >
<c:if test="${not empty classeAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${classeAjoute.idClass}</td>
</tr>

<tr>
<td>NOM</td>
<td>${classeAjoute.nom}</td>
</tr>

<tr>
<td>CRECHE</td>
<td>${classeAjoute.creche.nom}</td>
</tr>


<tr>
<td>NOMBRE PLACES</td>
<td>${classeAjoute.nombrePlaces}</td>
</tr>


</table>
</c:if>
</div>

