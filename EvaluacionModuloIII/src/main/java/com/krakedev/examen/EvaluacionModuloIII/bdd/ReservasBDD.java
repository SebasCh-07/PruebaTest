package com.krakedev.examen.EvaluacionModuloIII.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.examen.EvaluacionModuloIII.entidades.BUSES;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Reservas;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Rutas;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Usuarios;
import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;
import com.krakedev.examen.EvaluacionModuloIII.utils.ConexionBDD;

public class ReservasBDD {
	public ArrayList<Reservas> recuperarReservas() throws KrakeException {
		ArrayList<Reservas> reservas = new ArrayList<Reservas>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reservas reserva = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select re.codigo_reserva, us.id_persona, us.nombre, us.apellido, us.correo, us.telefono, "
					+ "re.boletos, ru.codigoR, ru.origen, ru.destino, ru.horario_salida, ru.bus, bu.capacidad_max, "
					+ "re.fecha_reserva "
					+ "from reservas re, usuarios us, rutas ru, buses bu "
					+ "where re.usuario_re = us.id_persona "
					+ "and re.ruta = ru.codigoR "
					+ "and ru.bus = bu.id_bus ");
			rs = ps.executeQuery();

			while (rs.next()) {
				String codigoReserva = rs.getString("codigo_reserva");
				
				String idPersona = rs.getString("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				String telefono = rs.getString("telefono");
				
				int boletos = rs.getInt("boletos");
				
				String codigoR = rs.getString("codigoR");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				
				Date horarioSalida = rs.getDate("horario_salida");
				
				String busId = rs.getString("bus");
				int capacidad = rs.getInt("capacidad_max");
				Date fecha_reserva = rs.getDate("fecha_reserva");	
				
				BUSES bus = new BUSES(busId, capacidad);
				
				Rutas ruta = new Rutas(codigoR, origen, destino, horarioSalida, bus);
				
				Usuarios usuario = new Usuarios(idPersona, nombre, apellido, correo, telefono);
				
				reserva = new Reservas(codigoReserva, usuario, boletos, ruta, fecha_reserva);

				reservas.add(reserva);
			}
		} catch (KrakeException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al consultar. Detalle" + e.getMessage());
		}
		return reservas;
	}
	
	public void insertar (Reservas reserva) throws KrakeException {
		Connection con = null;


		Date fechaAtual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaAtual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva) "
					+ "values (?, ?, ?, ?, ?)");
			ps.setString(1, reserva.getCodigoReserva());
			ps.setString(2, reserva.getUsuarioRe().getIdPersona());
			ps.setInt(3, reserva.getBoletos());
			ps.setString(4, reserva.getRuta().getCodigoR());
			ps.setDate(5, fechaSQL);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al insertar el la reserva. Detalle" + e.getMessage());
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
