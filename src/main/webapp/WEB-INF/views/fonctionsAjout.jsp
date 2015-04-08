<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formFonc" class="cadre">

    <f:form modelAttribute="fonction" action="ajouterFonction" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idFonction"/></td>
           <td><f:errors path="idFonction" cssClass="errors"/></td>
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

<div id="listfonc" class="cadre" >
<c:if test="${not empty fonctionAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${fonctionAjoute.idFonction}</td>
</tr>

<tr>
<td>LABELLE</td>
<td>${fonctionAjoute.labelle}</td>
</tr>



</table>
</c:if>
</div>

