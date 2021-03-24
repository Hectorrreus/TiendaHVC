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
@Table(name="Pedido")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_pedido;
	
	Date fecha;
	Float precio_final;
	
	//@ManyToOne(targetEntity=com.nunegal.tfctienda.modelos.Cliente.class)
	//@JoinColumn(name = "dni_cliente", nullable = false, updatable = false)
	String dni_cliente;
	
		
	public Pedido(Date fecha, float precio_final, String dni_cliente) {
		this.fecha = fecha;
		this.precio_final = precio_final;
		this.dni_cliente = dni_cliente;
	}
	
	public Pedido() {
		super();
	}

	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getPrecio_final() {
		return precio_final;
	}
	public void setPrecio_final(Float precio_final) {
		this.precio_final = precio_final;
	}
	public String getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni_cliente == null) ? 0 : dni_cliente.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id_pedido;
		result = prime * result + ((precio_final == null) ? 0 : precio_final.hashCode());
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
		Pedido other = (Pedido) obj;
		if (dni_cliente == null) {
			if (other.dni_cliente != null)
				return false;
		} else if (!dni_cliente.equals(other.dni_cliente))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_pedido != other.id_pedido)
			return false;
		if (precio_final == null) {
			if (other.precio_final != null)
				return false;
		} else if (!precio_final.equals(other.precio_final))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fecha=" + fecha + ", precio_final=" + precio_final
				+ ", dni_cliente=" + dni_cliente + "]";
	}
	
	
	
}
