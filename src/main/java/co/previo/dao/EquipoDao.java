package co.previo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import co.previo.modelo.Equipo;
import co.previo.utils.Conexion;



public class EquipoDao {

	private Conexion conexion;
	
	public static final String INSERT_USUARIO_SQL= "INSERT INTO cyclist (name, email, birthdate, country, team) VALUES (?, ?, ?, ?, ?);";
	public static final String DELETE_USUARIO_SQL= "DELETE FROM cyclist WHERE id = ?;";
	public static final String UPDATE_USUARIO_SQL= "UPDATE cyclist SET name = ?, email = ?, birthdate = ?, country = ? team = ? WHERE id = ?;";
	public static final String SELECT_USUARIO_BY_ID= "SELECT * FROM cyclist WHERE id = ?;";
	public static final String SELECT_ALL_USUARIO= "SELECT * FROM cyclist;";
	
	
	public EquipoDao() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Equipo equipo) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, equipo.getName());
			preparedStatement.setString(2, equipo.getEmail());
			preparedStatement.setString(3, equipo.getBirthdate());
			preparedStatement.setString(4, equipo.getCountry());
			preparedStatement.setString(5, equipo.getTeam());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void delete (int id) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
		
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void update(Equipo equipo) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, equipo.getName());
			preparedStatement.setString(2, equipo.getEmail());
			preparedStatement.setString(3, equipo.getBirthdate());
			preparedStatement.setString(4, equipo.getCountry());
			preparedStatement.setString(5, equipo.getTeam());
			preparedStatement.setInt(6, equipo.getId());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List <Equipo> selectAll(){
		
		List <Equipo> equipo = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_USUARIO);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthdate = rs.getString("birthdate");
				String country = rs.getString("country");
				String team = rs.getString("team");
				equipo.add(new Equipo(id, name, email, birthdate, country, team));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return equipo;
	}
	
	public Equipo select(int id){
		
		Equipo equipo = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {

				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthdate = rs.getString("birthdate");
				String country = rs.getString("country");
				String team = rs.getString("team");
				equipo = new Equipo(id, name, email, birthdate, country, team);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return equipo;
	}
}
