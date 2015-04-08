<div class="navbar navbar-default" role="navigation">

	<div class="navbar-inner">
	
<a class="navbar-brand" > <img alt="<%=request.getContextPath()%>/resources/Charisma Logo" src="<%=request.getContextPath()%>/resources/img/logo20.png" class="hidden-xs"/>
                <span>Administrateur</span></a>


		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<i class=" glyphicon glyphicon-off"></i><span
					class="hidden-sm hidden-xs"> <strong><font
						color="#8C001A">Admin</font></strong></span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">

				<li><a href="<c:url value="/j_spring_security_logout"/>"><strong><font
							color="#8C001A">Deconnexion</font></strong></a></li>
			</ul>
		</div>



	</div>
</div>
<!-- Menus -->
<div class="ch-container">
	<div class="row">

		<!-- left menu starts -->
		<div class="col-sm-2 col-lg-2">
			<div class="sidebar-nav">
				<div class="nav-canvas">
					<div class="nav-sm nav nav-stacked"></div>
					<ul class="nav nav-pills nav-stacked main-menu">

						<li class="nav-header hidden-md"><i
							class="glyphicon glyphicon-user"></i><font color="#8C001A"><strong>Gestion
									Personnages</strong></font></li>

						<!--  -->

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font><span> <strong>
										Personnages </strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<!--  -->

								
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Enfant</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminEnf/index"/>"><strong>Liste
											</strong></a></li>
										<li><a href="<c:url value="/adminEPA/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Parent</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminEnf/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminE/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Accompagnateur</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/admin/index"/>"><strong>Liste</strong>
										</a></li>
										<li><a href="<c:url value="/adminAccomp/index"/>"><strong>Ajout</strong></a></li>
									</ul></li>


							</ul></li>



						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font><span> <strong>Equipes
										</strong>
							</span></a>
							<ul class="nav nav-pills nav-stacked">

								

								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Equipe
												Educatif</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminListEdu/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminEqEdu/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Equipe
												Sanitaire</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminListSan/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminEqSan/index"/>"><strong>Ajout</strong></a></li>
									</ul></li>

								

							</ul></li>

						<li class="nav-header hidden-md"><i
							class="glyphicon glyphicon-tasks"></i> <font color="#8C001A"><strong>Gestion
									Facteurs</strong></font></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Inscription</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminInsc/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminInsA/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class=" glyphicon glyphicon-chevron-down"></i></font><span> <strong>Planning
										& Genre </strong></span></a>
							<ul class="nav nav-pills nav-stacked">

								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Planning
												Horraire</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminPlanLi/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminPlan/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Genre</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminGen/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminGenAj/index"/>"><strong>Ajout</strong></a></li>
									</ul></li>

							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class=" glyphicon glyphicon-chevron-down"></i></font><span> <strong>Club
										& Categorie</strong></span></a>
							<ul class="nav nav-pills nav-stacked">

								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Club</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminClubLi/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminClub/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Categorie</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminCategC/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminCateg/index"/>"><strong>Ajout</strong></a></li>
									</ul></li>

							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Consultation</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminConsu/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminConsA/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Classe</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminClasLi/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminClas/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Evennement</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminEv/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminEvenAj/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>
							
							<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Fonction</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminFonc/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminfoncAj/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>

						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font> <span><strong>Creche</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<c:url value="/adminCr/index"/>"><strong>Liste</strong></a></li>
								<li><a href="<c:url value="/adminCrech/index"/>"><strong>Ajout</strong></a></li>
							</ul></li>

						<li class="nav-header hidden-md"><i
							class="glyphicon glyphicon-shopping-cart"> </i><font
							color="#8C001A"><strong>Gestion Stocks</strong></font></li>


						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class=" glyphicon glyphicon-chevron-down"></i></font><span> <strong>Materiel
										& Type & stock</strong></span></a>
							<ul class="nav nav-pills nav-stacked">

								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Materiel</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminMaterielLi/index"/>"><strong>Liste</strong></a></li>
										<li><a href="<c:url value="/adminMater/index"/>"><strong>Ajout</strong></a></li>
									</ul>
								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span><font color="#606060"> <strong>Type</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminTypM/index"/>"><strong>Liste</strong>
										</a></li>
										<li><a href="<c:url value="/admintypAj/index"/>"><strong>Ajout</strong>
										</a></li>
									</ul></li>

								<li class="accordion"><a href="#"><i
										class="glyphicon glyphicon-chevron-down"></i><span> <font color="#606060"><strong>Stok</strong></font></span></a>
									<ul class="nav nav-pills nav-stacked">
										<li><a href="<c:url value="/adminStoc/index"/>"><strong>Liste</strong>
										</a></li>
										<li><a href="<c:url value="/adminStocAj/index"/>"><strong>Ajout
											</strong></a></li>
									</ul></li>

							</ul></li>




						<li class="nav-header hidden-md"><i
							class="glyphicon glyphicon-wrench"> </i> <font color="#8C001A"><strong>Gestion
									Securité</strong></font></li>





						<li class="accordion"><a href="#"><font color="#8C001A"><i
								class="glyphicon glyphicon-chevron-down"></i></font><span> <strong>
										Confidentialité</strong></span></a>
							<ul class="nav nav-pills nav-stacked">
								<!--  -->

								<li><a href="<c:url value="#"/>"><i
								class="glyphicon glyphicon-file"> </i><font color="#606060"><strong>Authentification
									</strong></font></a></li>

							</ul>
						<li class="nav-header hidden-md"><i
							class="glyphicon glyphicon-question-sign"> </i> <font color="#8C001A">
								<strong>Aide</strong>
						</font></li>


					</ul>

				</div>
			</div>
		</div>
		<!--/span-->
		<!-- left menu ends -->