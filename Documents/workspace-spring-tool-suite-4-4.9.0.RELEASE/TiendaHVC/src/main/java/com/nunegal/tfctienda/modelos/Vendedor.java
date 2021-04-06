package com.nunegal.tfctienda.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Vendedor")
public class Vendedor implements Serializable{

	@Id
	String dni_vendedor;
	
	String nombre;
	String apellidos;
	String correo;
	Date fecha_nacimiento;
	String contraseña;
	String telefono;
	String beneficio;
	
	
	public Vendedor() {
		
	}
	public Vendedor(String dni_vendedor, String nombre, String apellidos, String correo, Date fecha_nacimiento, String contraseña,
			String telefono, String beneficio) {
		
		this.dni_vendedor = dni_vendedor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.beneficio=beneficio;
		
	}
	public String getDni_vendedor() {
		return dni_vendedor;
	}
	public void setDni_vendedor(String dni_vendedor) {
		this.dni_vendedor = dni_vendedor;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((dni_vendedor == null) ? 0 : dni_vendedor.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (beneficio == null) {
			if (other.beneficio != null)
				return false;
		} else if (!beneficio.equals(other.beneficio))
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
		if (dni_vendedor == null) {
			if (other.dni_vendedor != null)
				return false;
		} else if (!dni_vendedor.equals(other.dni_vendedor))
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
	@Override
	public String toString() {
		return "Vendedor [dni_vendedor=" + dni_vendedor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", fecha_nacimiento=" + fecha_nacimiento + ", contraseña=" + contraseña
				+ ", telefono=" + telefono + ", beneficio=" + beneficio + "]";
	}
	
	
	
	
}
