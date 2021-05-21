package com.nunegal.tfctienda.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Carrito")
public class Carrito implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_carrito;

	String dni_usuario;
	
	public Carrito(String dni_usuario) {
		this.id_carrito = id_carrito;
		this.dni_usuario = dni_usuario;
	}

	public Carrito() {
	
	}
	

	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni_usuario == null) ? 0 : dni_usuario.hashCode());
		result = prime * result + id_carrito;
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
		Carrito other = (Carrito) obj;
		if (dni_usuario == null) {
			if (other.dni_usuario != null)
				return false;
		} else if (!dni_usuario.equals(other.dni_usuario))
			return false;
		if (id_carrito != other.id_carrito)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carrito [id_carrito=" + id_carrito + ", dni_usuario=" + dni_usuario + "]";
	}	
	
}
