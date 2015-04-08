<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Fournisseurs</h>
<div id="tableFournisseurs" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>CIN</th><th>TEL.PORTABLE</th><th>EMAIL</th>
</tr>
<c:forEach items="${fournisseurs}" var="four">
<tr>

<td>${four.idPerson}</td>
<td><img src="photoFourn?idFournisseur=${four.idPerson}" class="images_petit" /></td>
<td>${four.nom}</td>
<td>${four.prenom}</td>
<td>${four.cin}</td>
<td>${four.telephonePortable}</td>
<td>${four.email}</td>

<td><a href="supprimerListeFournisseur?idFournisseur=${four.idPerson}">Supprimer<a/></td>
<td><a href="modifierListeFournisseur?idFournisseur=${four.idPerson}">Modifier<a/></td>
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
<c:if  test="${fournisseur.idPerson!=0}">
<div id="formFour" class="cadre"> 
  
    <f:form modelAttribute="fournisseur" action="validerModificationFourn" method="post" enctype="multipart/form-data">  
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Photo:</td>
           <td>
           <c:if test="${fournisseur.idPerson!=null}">
           <img src="photoFourn?idFournisseur=${fournisseur.idPerson}" class="images_petit"/>
           
           </c:if>
           </td>
           <td><input  type="file" name="file"/><br>
           <f:textarea   path="nomPhoto" readonly="true"/></td>
           </tr>
       
       
           <tr>
           <td>Nom:</td>
           <td><f:input path="nom"/></td>
          <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prenom:</td>
           <td><f:input path="prenom"/></td>
           <td><f:errors path="prenom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Cin:</td>
           <td><f:input path="cin"/></td>
           <td><f:errors path="cin" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Adresse Societé:</td>
           <td><f:input path="adresseSociete"/></td>
           <td><f:errors path="adresseSociete" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Telephone Societé:</td>
           <td><f:input path="telephoneSociete"/></td>
           <td><f:errors path="telephoneSociete" cssClass="errors"/></td>
           </tr>
           
           
           
           <tr>
           <td>Tel.portable:</td>
           <td><f:input path="telephonePortable"/></td>
           <td><f:errors path="telephonePortable" cssClass="errors"/></td>
           </tr>
           
            <tr>
           <td>Email:</td>
           <td><f:input path="email"/></td>
           <td><f:errors path="email" cssClass="errors"/></td>
           </tr>
           
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
