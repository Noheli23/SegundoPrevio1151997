package co.previo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

	public Connection con;
	public Statement st=null;
	private static Conexion db;
	private PreparedStatement preparedStatement;
	
	public Conexion() {
		
		String url="jdbc:postgresql://queenie.db.elephantsql.com:5432/mnjgxshj";
		String usuario="mnjgxshj";
		String pass="Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			con=DriverManager.getConnection(url,usuario, pass);
			boolean valid = con.isValid(50000);
			System.out.print(valid ? "TEST OK" : "TEST FAIL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion() {
		if(db==null) {
			db=new Conexion();
		}
		return db;
	}
	
	public ResultSet consultar(String sql) {
		try {
			Statement st= this.con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet query() throws SQLException {
		ResultSet res=preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException {
		int result=preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getCon() {
		return this.con;
	}
	public PreparedStatement setPreparedStatement(String sql) throws SQLException{
		
		this.preparedStatement=con.prepareStatement(sql);
		return this.preparedStatement;
	}
}
