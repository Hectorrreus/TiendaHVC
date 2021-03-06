package com.nunegal.tfctienda.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linea_pedido")
public class Linea_pedido implements Serializable {

	@Id
	int id_lineapedido;
	
	int id_pedido;
	
	int id_producto;
	int unidades;
	public Linea_pedido() {
		super();
	}
	public Linea_pedido(int id_lineapedido, int id_pedido, int id_producto, int unidades) {
		super();
		this.id_lineapedido = id_lineapedido;
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.unidades = unidades;
	}
	public int getId_lineapedido() {
		return id_lineapedido;
	}
	public void setId_lineapedido(int id_lineapedido) {
		this.id_lineapedido = id_lineapedido;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
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
		result = prime * result + id_lineapedido;
		result = prime * result + id_pedido;
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
		Linea_pedido other = (Linea_pedido) obj;
		if (id_producto != other.id_producto)
			return false;
		if (id_lineapedido != other.id_lineapedido)
			return false;
		if (id_pedido != other.id_pedido)
			return false;
		if (unidades != other.unidades)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Lineas_pedido [id_lineapedido=" + id_lineapedido + ", id_pedido=" + id_pedido + ", idProducto="
				+ id_producto + ", unidades=" + unidades + "]";
	}
	
	
	
	}
