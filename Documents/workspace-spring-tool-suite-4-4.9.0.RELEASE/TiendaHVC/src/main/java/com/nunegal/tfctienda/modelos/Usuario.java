package com.nunegal.tfctienda.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	@Id
	//@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "dni_usuario", nullable = false)
	String dni_usuario;
	
	String nombre;
	String apellidos;
	String correo;
	String contraseña;
	String telefono;
	Boolean esvendedor;
	Float beneficios;
	
	
	public Usuario() {
		
	}


	public Usuario(String dni_usuario, String nombre, String apellidos, String correo,
			String contraseña, String telefono, Boolean esvendedor, Float beneficios) {
		super();
		this.dni_usuario = dni_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.esvendedor = esvendedor;
		this.beneficios = beneficios;
	}


	public String getDni_usuario() {
		return dni_usuario;
	}


	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Boolean getEsvendedor() {
		return esvendedor;
	}


	public void setEsvendedor(Boolean esvendedor) {
		this.esvendedor = esvendedor;
	}


	public Float getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(Float beneficios) {
		this.beneficios = beneficios;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((dni_usuario == null) ? 0 : dni_usuario.hashCode());
		result = prime * result + ((esvendedor == null) ? 0 : esvendedor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (beneficios == null) {
			if (other.beneficios != null)
				return false;
		} else if (!beneficios.equals(other.beneficios))
			return false;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (dni_usuario == null) {
			if (other.dni_usuario != null)
				return false;
		} else if (!dni_usuario.equals(other.dni_usuario))
			return false;
		if (esvendedor == null) {
			if (other.esvendedor != null)
				return false;
		} else if (!esvendedor.equals(other.esvendedor))
			return false;		
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Usuario [dni_usuario=" + dni_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", fecha_nacimiento=" +", contraseña=" + contraseña + ", telefono="
				+ telefono + ", esvendedor=" + esvendedor + ", beneficios=" + beneficios + "]";
	}
	
	
	
	
}
