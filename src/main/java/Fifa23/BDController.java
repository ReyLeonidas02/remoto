package Fifa23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {
	
	private Connection conexion;
	
	public BDController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/fifa23", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error en el constructor de BDController: " + e.getMessage());
        }
    }

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	public Equipo dameEquipo(int cod_equipo) {
		Equipo equipo = new Equipo();
		String consulta = "SELECT * FROM equipos WHERE equipos.cod_equipo = '"+cod_equipo+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				equipo = new Equipo(rs.getInt("cod_equipo"),rs.getString("nombre"),rs.getInt("cod_liga"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipo;
	}
	
	public ArrayList <Equipo> dameEquiposDeLiga (int cod_liga) {
		ArrayList <Equipo> equipos = new ArrayList();
		String consulta = "SELECT * FROM equipos WHERE equipos.cod_liga = '"+cod_liga+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				equipos.add(new Equipo(rs.getInt("cod_equipo"),rs.getString("nombre"),rs.getInt("cod_liga")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}
	
	public Jugador dameJugador(int cod_jugador) {
		Jugador jugador = new Jugador();
		String consulta = "SELECT * FROM jugadores WHERE jugadores.cod_jugador = '"+cod_jugador+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				jugador = new Jugador(rs.getInt("cod_jugador"),rs.getString("nombre"),rs.getInt("cod_equipo"),
						rs.getString("pierna"),rs.getInt("altura"),rs.getString("pais"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugador;
	}
	
	public ArrayList <Jugador> dameJugadoresDeEquipo (int cod_equipo){
		ArrayList <Jugador> jugadores = new ArrayList();
		String consulta = "SELECT * FROM jugadores WHERE jugadores.cod_equipo = '"+cod_equipo+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				jugadores.add(new Jugador(rs.getInt("cod_jugador"),rs.getString("nombre"),rs.getInt("cod_equipo"),
						rs.getString("pierna"),rs.getInt("altura"),rs.getString("pais")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugadores;
	}
	
	public String damePaisDeLigaDeEquipo (int cod_equipo) {
		String pais = "";
		String consulta = "SELECT ligas.pais FROM ligas INNER JOIN equipos ON ligas.cod_liga = equipos.cod_liga WHERE cod_equipo = '"+cod_equipo+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				pais = rs.getString("pais");
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pais;
	}
	
	public Liga dameLiga(int cod_liga) {
		Liga liga = new Liga();
		String consulta = "SELECT * FROM ligas WHERE cod_liga = '"+cod_liga+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				liga = new Liga(rs.getInt("cod_liga"),rs.getString("nombre"),rs.getString("pais"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liga;
	}
	
	public Liga dameLigaDeEquipo (int cod_equipo) {
		Liga liga = new Liga();
		String consulta = "SELECT * FROM ligas INNER JOIN equipos ON ligas.cod_liga=equipos.cod_liga WHERE cod_equipo = '"+cod_equipo+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				liga = new Liga(rs.getInt("cod_liga"),rs.getString("nombre"),rs.getString("pais"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liga;
	}
	
	public Carta dameCarta(int cod_jugador, String nom_carta) {
		Carta carta = new Carta();
		String consulta = "SELECT * FROM cartas WHERE cod_jugador = '"+cod_jugador+"' AND cartas.nombre ='"+nom_carta+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				carta = new Carta(rs.getString("nombre"),rs.getInt("cod_jugador"),rs.getInt("rat"),rs.getString("pos"),
						rs.getInt("precio"),rs.getInt("pac"),rs.getInt("sho"),rs.getInt("pas"),rs.getInt("dri"),
						rs.getInt("def"),rs.getInt("phy"),rs.getInt("pierna_mala"),rs.getInt("filigranas"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carta;
	}
	
	public ArrayList <Carta> dameCartasJugador (int cod_jugador){
		ArrayList <Carta> cartas = new ArrayList();
		String consulta = "SELECT * FROM cartas WHERE cartas.cod_jugador = '"+cod_jugador+"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				cartas.add(new Carta(rs.getString("nombre"),rs.getInt("cod_jugador"),rs.getInt("rat"),rs.getString("pos"),
						rs.getInt("precio"),rs.getInt("pac"),rs.getInt("sho"),rs.getInt("pas"),rs.getInt("dri"),
						rs.getInt("def"),rs.getInt("phy"),rs.getInt("pierna_mala"),rs.getInt("filigranas")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas;
	}
	
	public ArrayList<Carta> listadoCartas () {
		ArrayList <Carta> cartas = new ArrayList();
		String consulta = "SELECT * FROM cartas";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				cartas.add(new Carta(rs.getString("nombre"),rs.getInt("cod_jugador"),rs.getInt("rat"),rs.getString("pos"),
						rs.getInt("precio"),rs.getInt("pac"),rs.getInt("sho"),rs.getInt("pas"),rs.getInt("dri"),
						rs.getInt("def"),rs.getInt("phy"),rs.getInt("pierna_mala"),rs.getInt("filigranas")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas;
	}
	
	public ArrayList<Jugador> listadoJugadores () {
		ArrayList <Jugador> jugadores = new ArrayList();
		String consulta = "SELECT * FROM jugadores";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				jugadores.add(new Jugador(rs.getInt("cod_jugador"),rs.getString("nombre"),rs.getInt("cod_equipo"),
						rs.getString("pierna"),rs.getInt("altura"),rs.getString("pais")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugadores;
	}
	
	public ArrayList<Equipo> listadoEquipos () {
		ArrayList <Equipo> equipos = new ArrayList();
		String consulta = "SELECT * FROM equipos";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				equipos.add(new Equipo(rs.getInt("cod_equipo"),rs.getString("nombre"),rs.getInt("cod_liga")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}
	
	public ArrayList<Liga> listadoLigas () {
		ArrayList <Liga> ligas = new ArrayList();
		String consulta = "SELECT * FROM ligas";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				ligas.add(new Liga(rs.getInt("cod_liga"),rs.getString("nombre"),rs.getString("pais")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ligas;
	}
	
	public boolean existeEquipo (int cod_equipo) {
		for(Equipo e:listadoEquipos()) {
			if(e.getCod_equipo()==cod_equipo) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeLiga (int cod_liga) {
		for(Liga l:listadoLigas()) {
			if(l.getCod_liga()==cod_liga) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeJugador (int cod_jugador) {
		for(Jugador j:listadoJugadores()) {
			if(j.getCod_jugador()==cod_jugador) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeCarta (int cod_jugador) {
		for(Carta c:listadoCartas()) {
			if(c.getCod_jugador()==cod_jugador) {
				return true;
			}
		}
		return false;
	}
	
	public void altaJugador (Jugador jugador) {
		String insert = "INSERT INTO jugadores (cod_jugador, nombre, cod_equipo, pierna, altura, pais)"
				+ "VALUES ('"+jugador.getCod_jugador()+"','"+jugador.getNombre()+"','"+jugador.getCod_equipo()+"','"+
				jugador.getPierna()+"','"+jugador.getAltura()+"','"+jugador.getPais()+"')";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(insert);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altaEquipo (Equipo equipo) {
		String insert = "INSERT INTO equipos (cod_equipo, nombre, cod_liga) VALUES ('"+equipo.getCod_equipo()+"','"
				+equipo.getNombre()+"','"+equipo.getCod_liga()+"')";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(insert);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altaLiga (Liga liga) {
		String insert = "INSERT INTO equipos (cod_liga, nombre, pais) VALUES ('"+liga.getCod_liga()+"','"
				+liga.getNombre()+"','"+liga.getPais()+"')";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(insert);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bajaJugador (int cod_jugador) {
		String delete = "DELETE FROM jugadores WHERE jugadores.cod_jugador='"+cod_jugador+"'";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(delete);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bajaEquipo (int cod_equipo) {
		String delete = "DELETE FROM equipos WHERE equipos.cod_equipo = '"+cod_equipo+"'";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(delete);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bajaLiga (int cod_liga) {
		String delete = "DELETE FROM ligas WHERE ligas.cod_liga = '"+cod_liga+"'";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(delete);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarJugador (Jugador jugador) {
		String update = "UPDATE jugadores SET jugadores.nombre='"+jugador.getNombre()+"', jugadores.cod_equipo='"+jugador.getCod_equipo()+
				"', jugadores.pierna='"+jugador.getPierna()+"', jugadores.altura='"+jugador.getAltura()+"', jugadores.pais='"+jugador.getPais()+"'"
						+ " WHERE jugadores.cod_jugador='"+jugador.getCod_jugador()+"'";
		try {
			Statement st = this.conexion.createStatement();
			st.executeUpdate(update);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int incrementCodJug() {
	    int valorMax = 0;
	    String consulta = "SELECT (MAX(jugadores.cod_jugador)+1) AS max_cod FROM jugadores";
	    try {
	        Statement st = this.conexion.createStatement();
	        ResultSet rs = st.executeQuery(consulta);
	        while (rs.next()) {
	            valorMax = rs.getInt("max_cod");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return valorMax;
	}
	
	public int incrementCodEq() {
	    int valorMax = 0;
	    String consulta = "SELECT (MAX(equipos.cod_equipo)+1) AS max_cod FROM equipos";
	    try {
	        Statement st = this.conexion.createStatement();
	        ResultSet rs = st.executeQuery(consulta);
	        while (rs.next()) {
	            valorMax = rs.getInt("max_cod");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return valorMax;
	}
	
	public int incrementCodLi() {
	    int valorMax = 0;
	    String consulta = "SELECT (MAX(ligas.cod_liga)+1) AS max_cod FROM ligas";
	    try {
	        Statement st = this.conexion.createStatement();
	        ResultSet rs = st.executeQuery(consulta);
	        while (rs.next()) {
	            valorMax = rs.getInt("max_cod");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return valorMax;
	}
	
	
	
	

}