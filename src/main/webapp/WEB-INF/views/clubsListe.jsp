<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Clubs</h>
<div id="tableClubs" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>NOM</th><th>INSCRIPTIONS</th><th>CAREGORIE CLUBS</th>
</tr>
<c:forEach items="${clubs}" var="clu">
<tr>

<td>${clu.idClub}</td>
<td>${clu.nom}</td>
<td>${clu.categorieClub.labelle}</td>
<td>${clu.inscription.annee}</td>

<td><a href="supprimerListeClubs?idClubs=${clu.idClub}">Supprimer<a/></td>
<td><a href="modifierListeClubs?idClubs=${clu.idClub}">Modifier<a/></td>
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
<c:if  test="${club.idClub!=0}">
<div id="formClub" class="cadre"> 
  
    <f:form modelAttribute="club" action="validerModificationClub" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idClub"/></td>
           <td><f:errors path="idClub" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Nom:</td>
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
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
