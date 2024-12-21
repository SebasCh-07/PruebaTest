package com.krakedev.examen.EvaluacionModuloIII.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;


public class ConexionBDD {
	public static Connection obtenerConexion() throws KrakeException {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionExamen");
			con = ds.getConnection();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error de conexion");

		} 
		
		return con;
	}
}
