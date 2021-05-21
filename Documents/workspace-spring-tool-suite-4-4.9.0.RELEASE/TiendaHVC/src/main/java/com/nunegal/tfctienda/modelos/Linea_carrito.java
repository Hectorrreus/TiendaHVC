package com.nunegal.tfctienda.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linea_carrito")
public class Linea_carrito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_lineacarrito;
	
	int id_carrito;
	
	int id_producto;
	int unidades;
	public Linea_carrito() {
		super();
	}
	public Linea_carrito(int id_lineacarrito, int id_carrito, int id_producto, int unidades) {
		super();
		this.id_lineacarrito = id_lineacarrito;
		this.id_carrito = id_carrito;
		this.id_producto = id_producto;
		this.unidades = unidades;
	}
	public int getId_lineacarrito() {
		return id_lineacarrito;
	}
	public void setId_lineacarrito(int id_lineacarrito) {
		this.id_lineacarrito = id_lineacarrito;
	}
	public int getId_carrito() {
		return id_carrito;
	}
	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}
	public int getIdProducto() {
		return id_producto;
	}
	public void setIdProducto(int idProducto) {
		this.id_producto = idProducto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_producto;
		result = prime * result + id_lineacarrito;
		result = prime * result + id_carrito;
		result = prime * result + unidades;
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
		Linea_carrito other = (Linea_carrito) obj;
		if (id_producto != other.id_producto)
			return false;
		if (id_lineacarrito != other.id_lineacarrito)
			return false;
		if (id_carrito != other.id_carrito)
			return false;
		if (unidades != other.unidades)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Lineas_carrito [id_lineacarrito=" + id_lineacarrito + ", id_carrito=" + id_carrito + ", idProducto="
				+ id_producto + ", unidades=" + unidades + "]";
	}
	
	
	
	}
