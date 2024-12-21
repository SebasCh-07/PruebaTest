package com.krakedev.examen.EvaluacionModuloIII.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.examen.EvaluacionModuloIII.entidades.BUSES;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Rutas;
import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;
import com.krakedev.examen.EvaluacionModuloIII.utils.ConexionBDD;

public class RutasBDD {
	public ArrayList<Rutas> recuperarRutas() throws KrakeException {
		ArrayList<Rutas> rutas = new ArrayList<Rutas>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rutas ruta = null;
		

		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select r.codigoR, r.origen, r.destino, r.horario_salida, b.id_bus, b.capacidad_max "
					+ "from rutas r, buses b "
					+ "where r.bus = b.id_bus ");
			rs = ps.executeQuery();

			while (rs.next()) {
				String codigoR = rs.getString("codigoR");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				Date horarioSalida = rs.getDate("horario_salida");	
				
				String idBus = rs.getString("id_bus");
				int capMax = rs.getInt("capacidad_max");
				
				BUSES bus = new BUSES(idBus, capMax);
				
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				
				String sd = sdf.format(horarioSalida);

				ruta = new Rutas(codigoR, origen, destino, horarioSalida, bus);
				rutas.add(ruta);
			}
		} catch (KrakeException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al consultar. Detalle" + e.getMessage());
		}
		return rutas;
	}
	public void insertar (Rutas ruta) throws KrakeException {
		Connection con = null;


		Date fechaAtual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaAtual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into rutas (codigoR, origen, destino, horario_salida, bus) "
					+ "values(?, ?, ?, ?, ?);");
			ps.setString(1, ruta.getCodigoR());
			ps.setString(2, ruta.getOrigen());
			ps.setString(3, ruta.getDestino());
			ps.setDate(4, fechaSQL);
			ps.setString(5, ruta.getBus().getIdBUS());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al insertar el la ruta. Detalle" + e.getMessage());
		} catch (KrakeException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}