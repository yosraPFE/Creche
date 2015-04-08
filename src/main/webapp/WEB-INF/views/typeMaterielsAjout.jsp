<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formTypMa" class="cadre">

    <f:form modelAttribute="typeMateriel" action="ajouterTypeMateriels" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idTypeMateriel"/></td>
           <td><f:errors path="idTypeMateriel" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Labelle</td>
           <td><f:input path="labelle"/></td>
           <td><f:errors path="labelle" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listtypMat" class="cadre" >
<c:if test="${not empty typeMaterielAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${typeMaterielAjoute.idTypeMateriel}</td>
</tr>

<tr>
<td>LABELLE</td>
<td>${typeMaterielAjoute.labelle}</td>
</tr>



</table>
</c:if>
</div>

