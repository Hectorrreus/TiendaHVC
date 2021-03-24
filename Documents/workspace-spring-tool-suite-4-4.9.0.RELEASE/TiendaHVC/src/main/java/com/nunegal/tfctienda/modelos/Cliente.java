package com.nunegal.tfctienda.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{

	@Id
	//@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "dni_cliente", nullable = false)
	String dni_cliente;
	
	String nombre;
	String apellidos;
	String correo;
	Date fecha_nacimiento;
	String contraseña;
	String telefono;
	
	
	public Cliente() {
		
	}
	public Cliente(String dni_cliente, String nombre, String apellidos, String correo, Date fecha_nacimiento, String contraseña,
			String telefono) {
		
		this.dni_cliente = dni_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.contraseña = contraseña;
		this.telefono = telefono;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((dni_cliente == null) ? 0 : dni_cliente.hashCode());
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
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
		if (dni_cliente == null) {
			if (other.dni_cliente != null)
				return false;
		} else if (!dni_cliente.equals(other.dni_cliente))
			return false;
		if (fecha_nacimiento == null) {
			if (other.fecha_nacimiento != null)
				return false;
		} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
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
	public String getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fechanacimiento) {
		this.fecha_nacimiento = fechanacimiento;
	}
	@Override
	public String toString() {
		return "Cliente [dni_cliente=" + dni_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", contraseña=" + contraseña + ", telefono=" + telefono + ", fechanacimiento="
				+ fecha_nacimiento + "]";
	}
	
	
	
	
}
