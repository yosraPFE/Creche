<%@page import="org.gestion.cr.entities.Enfant"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>

<div id="formEnf" class="cadre">

    <f:form modelAttribute="enfant" action="ajouterEnfant" method="post" enctype="multipart/form-data">  <!--enctype="" pour le Upload on vas telecharger une photo  -->

       <table>
           <tr>
           <td>ID</td>
           <td><f:input path="idPerson"/></td>
           <td><f:errors path="idPerson" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Photo</td>
           <td>
           <c:if test="${enfant.idPerson!=null}">
           <img src="photoEnf?idEnfant=${enfant.idPerson}" class="images_petit"/>
           </c:if>
           </td>
           <td><input  type="file" name="file"/></td>
           </tr>
       
       
           <tr>
           <td>Nom</td>
           <td><f:input path="nom"/></td>
           <td><f:errors path="nom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Prenom</td>
           <td><f:input path="prenom"/></td>
           <td><f:errors path="prenom" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Sexe</td>
           <td><f:input path="sexe"/></td>
           <td><f:errors path="sexe" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Date de Naissance</td>
           <td><f:input  type="date" path="dateNaissance"/></td>
           <td><f:errors path="dateNaissance" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Lieu de Naissance</td>
           <td><f:input path="lieuNaissance"/></td>
           <td><f:errors path="lieuNaissance" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Langue</td>
           <td><f:input path="langue"/></td>
           <td><f:errors path="langue" cssClass="errors"/></td>
           </tr>
           
           
           <tr>
           <td>Antecedants Medicaux</td>
           <td><f:textarea path="antecedantsMedicaux"/></td>
           <td><f:errors path="antecedantsMedicaux" cssClass="errors"/></td>
           </tr>
           
           
           
           
           <tr>
           <td>Certifié Medicalement?</td>
           <td><f:checkbox path="certificatMedicale"/></td>
           <td><f:errors path="certificatMedicale" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Autorisé pour la prise photo?</td>
           <td><f:checkbox path="autorisationPrisePhoto"/></td>
           <td><f:errors path="autorisationPrisePhoto" cssClass="errors"/></td>
           </tr>
           
           
           
           <tr>
           <td>Situation Parentale</td>
           <td><f:checkbox path="situationParentale" /></td>
           <td><f:errors path="situationParentale" cssClass="errors"/></td>
           </tr>

           <tr>
           <td>Inscri a un tel evennement?</td>
           <td><f:checkbox path="inscriptionEvenement" /></td>
           
           <td><f:errors path="inscriptionEvenement" cssClass="errors"/></td>
           </tr>



           <tr>
           
           <td>
           <fmt:formatDate  value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd HH:mm:ss" var="myDate" />
           <f:input type="hidden" path="dateInscription" value="${myDate}"/>
           </td>
           <td><f:errors path="dateInscription" cssClass="errors"/></td>
           </tr>
           
           
           
           
          
           
           <tr>
           <td>Nom et Prenom Pediatre</td>
           <td><f:input path="nomPrenomPediatre"/></td>
           <td><f:errors path="nomPrenomPediatre" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Tel.Pediatre</td>
           <td><f:input path="telephonePortablePediatre"/></td>
           <td><f:errors path="telephonePortablePediatre" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nombre Frère</td>
           <td><f:input path="nombreFreres"/></td>
           <td><f:errors path="nombreFreres" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Nombre Soeurs</td>
           <td><f:input path="nombreSoeur"/></td>
           <td><f:errors path="nombreSoeur" cssClass="errors"/></td>
           </tr>
           
            
           
          
           
          
           
           <tr>
           <td><input type="submit" value="Valider et Ajouter Tarif"/></td>
           </tr>
      </table>
  
    </f:form>

</div>
<div id="tableEnfants" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>PHOTO</th><th>NOM</th><th>PRENOM</th><th>DATE Naissance</th><th>Autorisation Prise Photo</th>
</tr>
<c:forEach items="${enfants}" var="enf">
<tr>

<td>${enf.idPerson}</td>
<td><img src="photoEnf?idEnfant=${enf.idPerson}" class="images_petit" /></td>
<td>${enf.nom}</td>
<td>${enf.prenom}</td>
<td>${enf.dateNaissance}</td>
<td>${enf.autorisationPrisePhoto}</td>
<td>${enf.dateInscription}</td>


<td><a href="supprimerEnfant?idEnfant=${enf.idPerson}">Supprimer<a/></td>
<td><a href="modifierEnfant?idEnfant=${enf.idPerson}">Modifier<a/></td>
</tr>
</c:forEach>

</table>
</div>