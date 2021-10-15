package co.tienda.generica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;	
	private String password;	
	private String usuario;
	
	public Usuario() {
		super();
	}

	public Integer getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Usuario(Integer cedula_usuario, String email_usuario, String nombre_usuario, String password,
			String usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuarios [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password=" + password + ", usuario=" + usuario + "]";
	}

}
