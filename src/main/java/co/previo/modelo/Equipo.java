package co.previo.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo implements Serializable{

	private Integer id;
	private String name;
	private String email;
	private String birthdate;
	private String country;
	private String team;
	
	public Equipo(String name, String email, String birthdate, String country, String team) {
		
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.country = country;
		this.team = team;
	}
	
	
	
}
