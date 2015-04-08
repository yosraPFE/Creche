<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>

<head>
<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>
<title>Page Accueil Administrateur</title>
</head>

<body>
	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>


	<!-- table -->

	

	

	<div>


		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div></div>

			<div class="row">
				<div class="box col-md-11">
					<div class="box-inner">


						

						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-picture"></i> <font color="#8C001A">Bienvenue � notre Cr�che l'Excellence
									</font>
							</h2>
							
							
               

							
						</div>
						
						<img alt="<%=request.getContextPath()%>/resources/Charisma Logo" src="<%=request.getContextPath()%>/resources/img/creche.png" class="hidden-xs"/>
						
					</div>
					
					
				</div>
</div>

</div>
</div>

<!-- footer -->

<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>