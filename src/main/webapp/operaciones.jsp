<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="Fifa23.*" %>
<%@ page import="java.io.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html">
	
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<title>Proyecto Web FIFA23</title>
</head>

<body class="is-preload">
		<div id="page-wrapper">
		
		<%
		String pagina = request.getParameter("pagina");
		BDController control = new BDController();
		String mensajeUsuario = "";
		
		switch (pagina){
			case "altajugador":
				int codJugador = control.incrementCodJug();
				String nombre = request.getParameter("nombre");
				String pierna = request.getParameter("pierna");
				int altura = Integer.parseInt(request.getParameter("altura"));
				String pais = request.getParameter("pais");
				int equipo = Integer.parseInt(request.getParameter("equipo"));
				Jugador jugador = new Jugador(codJugador, nombre, equipo, pierna, altura, pais);
				control.altaJugador(jugador);
				mensajeUsuario = "El jugador ha sido dado de alta satisfactoriamente";
			break;
			case "bajajugador":
				int cod_jugador = Integer.parseInt(request.getParameter("codJugador"));
				if(control.existeJugador(cod_jugador)){
					control.bajaJugador(cod_jugador);
					mensajeUsuario = "El jugador ha sido borrado satisfactoriamente";
				}else {
					mensajeUsuario = "El jugador no existe en la base de datos";
				}
			break;
			case "bajaequipo":
				int cod_equipo = Integer.parseInt(request.getParameter("bajaEquipo"));
				if(control.existeEquipo(cod_equipo)){
					control.bajaEquipo(cod_equipo);
					mensajeUsuario = "El equipo ha sido borrado satisfactoriamente";
				}else{
					mensajeUsuario = "Ha habido un problema a la hora de borrar el equipo";
				}
			break;
			case "bajaliga":
				int cod_liga = Integer.parseInt(request.getParameter("bajaLiga"));
				if(control.existeLiga(cod_liga)){
					control.bajaLiga(cod_liga);
					mensajeUsuario = "La liga ha sido borrada satisfactoriamente";
				}else{
					mensajeUsuario = "No se ha podido eliminar una liga inexistente";
				}
			break;
			case "altaequipo":
				int cod_equipo_alta = control.incrementCodEq();
				String nom_Eq = request.getParameter("nombre_equipo");
				int cod_liga_altaeq = Integer.parseInt(request.getParameter("codigo_liga_equipo"));
				Equipo altaequipo = new Equipo(cod_equipo_alta, nom_Eq, cod_liga_altaeq);
				if(control.existeLiga(cod_liga_altaeq)){
					control.altaEquipo(altaequipo);
					mensajeUsuario = "Se ha dado de alta satisfactoriamente el nuevo equipo";
				}else{
					mensajeUsuario = "Ha habido un error, para dar de alta un equipo tiene que ser en una liga existente";
				}
			break;
			case "altaliga":
				int cod_liga_alta = control.incrementCodLi();
				String nom_Li = request.getParameter("nombre_liga_alta");
				String pais_Li = request.getParameter("pais_liga");
				Liga liga = new Liga(cod_liga_alta, nom_Li, pais_Li);
				control.altaLiga(liga);
				mensajeUsuario = "Se ha dado de alta la liga satisfactoriamente";
			break;
			case "modificarJug2":
				String nombreJugMod = request.getParameter("nombreModJug");
				String piernaJugMod = request.getParameter("piernaModJug");
				int alturaJugMod = Integer.parseInt(request.getParameter("alturaModJug"));
				String paisJugMod = request.getParameter("paisModJug");
				int cod_jugador_mod = Integer.parseInt(request.getParameter("cod_jugador_mod"));
				int cod_equipo_mod = Integer.parseInt(request.getParameter("equipo_mod"));
				Jugador jugador_mod = new Jugador(cod_jugador_mod, nombreJugMod, cod_equipo_mod, piernaJugMod, alturaJugMod, paisJugMod);
				control.modificarJugador(jugador_mod);
				mensajeUsuario = "Se han modificado exitosamente los datos de este jugador ";
			break;
		}

		%>
			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.jsp" id="logo">FIFA23</a></a></h1>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li class="current"><a href="index.jsp">Inicio</a></li>
								<li>
									<a href="#">Listados</a>
									<ul>
										<li><a href="ligas.jsp">FIFA 23 Ligas</a></li>
										<li><a href="equipos.jsp">FIFA 23 Equipos</a></li>
										<li><a href="jugadores.jsp">FIFA 23 Jugadores</a></li>
									</ul>
								</li>
								<li>
									<a href="#">Operaciones</a>
									<ul>
										<li>
											<a href="#">Jugadores</a>
											<ul>
												<li><a href="operaciones.jsp?tipo=altajugador">Alta Jugador</a></li>
												<li><a href="#">Baja Jugador</a></li>
												<li><a href="#">Modificar Jugador</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Equipos</a>
											<ul>
												<li><a href="#">Alta Equipo</a></li>
												<li><a href="#">Baja Equipo</a></li>
												<li><a href="#">Modificar Equipo</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Ligas</a>
											<ul>
												<li><a href="#">Alta Liga</a></li>
												<li><a href="#">Baja Liga</a></li>
												<li><a href="#">Modificar Liga</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Cartas</a>
											<ul>
												<li><a href="#">Alta Carta</a></li>
												<li><a href="#">Baja Carta</a></li>
												<li><a href="#">Modificar Carta</a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li ><a href="#">Simulador</a>
									<ul>
										<li><a href="#">Construye tu Equipo</a></li>
									</ul>
								</li>
							</ul>
						</nav>
				</div>
				<!-- Main -->
				<section class="wrapper style1" style="height:500px;">
					<div class="container">
						<div id="content">

							<!-- Content -->
							
								<article>
									
									<section class="col-6 col-12-narrower">
									
								<h3><%=mensajeUsuario %></h3>
								
							</section>
								</article>
						</div>
					</div>
				</section>
										
			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h3>Listados</h3>
								<ul class="links">
									<li><a href="jugadores.asp">Listado de Jugadores</a></li>
									<li><a href="equipos.asp">Listado de Equipos</a></li>
									<li><a href="ligas.asp">Listado de Ligas</a></li>
								
								</ul>
							</section>
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h3>Más Opciones</h3>
								<ul class="links">
									<li><a href="altaJugador.jsp">Alta Jugador</a></li>
									<li><a href="altaEquipo.jsp">Alta Equipo</a></li>
									<li><a href="altaLiga.jsp">Alta Liga</a></li>
									<li><a href="altaCarta.jsp">Alta Carta</a></li>
									<li><a href="modifiJugador.jsp">Modificar Jugador</a></li>
									<li><a href="modifiEquipo.jsp">Modificar Equipo</a></li>
									<li><a href="modifiLiga.jsp">Modificar Liga</a></li>
									<li><a href="modifiCarta.jsp">Modificar Carta</a></li>
								</ul>
							</section>
							<section class="col-6 col-12-narrower">
								<h3>Solicita Información</h3>
								<form>
									<div class="row gtr-50">
										<div class="col-6 col-12-mobilep">
											<input type="text" name="name" id="name" placeholder="Name" />
										</div>
										<div class="col-6 col-12-mobilep">
											<input type="email" name="email" id="email" placeholder="Email" />
										</div>
										<div class="col-12">
											<textarea name="message" id="message" placeholder="Message" rows="5"></textarea>
										</div>
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" class="button alt" value="Enviar Email" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>

					<!-- Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; FIFA 23. Todos los derechos reservados</li><li>Design: <a href="https://www.centronelson.org">Centro Nelson</a></li>
							</ul>
						</div>

				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="assets/js/index.js"></script>
			<script src="assets/js/dropdown.js"></script>

</body>

</html>