<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formClub" class="cadre">

    <f:form modelAttribute="club" action="ajouterClub" method="post" >  

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idClub"/></td>
           <td><f:errors path="idClub" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Nom</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Inscription</td>
           <td><f:select path="inscription.idinscription" items="${inscriptions}" itemValue="idinscription" itemLabel="annee"></f:select></td>
           <td><f:errors path="inscription.idinscription" items="${inscriptions}" itemValue="idinscription" itemLabel="annee" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Categorie Clubs</td>
           <td><f:select path="categorieClub.idCateg" items="${CategorieClubs}" itemValue="idCateg" itemLabel="labelle"></f:select></td>
           <td><f:errors path="categorieClub.idCateg" items="${CategorieClubs}" itemValue="idCateg" itemLabel="labelle" cssClass="errors"/></td>
           </tr>
          
           
           <tr>
           <td><input type="submit" value="Ajouter et afficher details"/></td>
           </tr>
      </table>
  
    </f:form>

</div>

<div id="listClub" class="cadre" >
<c:if test="${not empty clubAjoute}">

<table class="tab1">

<tr>
<td>ID</td>
<td>${clubAjoute.idClub}</td>
</tr>

<tr>
<td>NOM</td>
<td>${clubAjoute.nom}</td>
</tr>

<tr>
<td>INSCRIPTION</td>
<td>${clubAjoute.inscription.annee}</td>
</tr>


<tr>
<td>CATEGORIE CLUBS</td>
<td>${clubAjoute.categorieClub.labelle}</td>
</tr>


</table>
</c:if>
</div>

