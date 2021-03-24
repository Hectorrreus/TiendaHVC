package com.nunegal.tfctienda.modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

//@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name="direcciones_entrega")
public class Direccion_entrega implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_direccion;
	
	
	//@ManyToOne(targetEntity=com.nunegal.tfctienda.modelos.Cliente.class)
	//@JoinColumn(name = "dni_cliente", nullable = false)
	String dni_cliente;
	
	String pais;
	String provincia;
	String ciudad;
	String codigopostal;
	String calle;
	String numero;
	
	public Direccion_entrega(String dni_cliente, String pais, String provincia,
			String ciudad, String codigopostal, String calle, String numero) {
		super();
		//this.id_direccion = (Integer) null;
		this.dni_cliente = dni_cliente;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.codigopostal = codigopostal;
		this.calle = calle;
		this.numero = numero;
	}
	
	public Direccion_entrega() {
		super();
	}
	public int getId_direccionesentrega() {
		return id_direccion;
	}
	public void setId_direccionesentrega(int id_direccionesentrega) {
		this.id_direccion= id_direccionesentrega;
	}
	public String getDniCliente() {
		return dni_cliente;
	}
	public void setDni_Cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((codigopostal == null) ? 0 : codigopostal.hashCode());
		result = prime * result + ((dni_cliente == null) ? 0 : dni_cliente.hashCode());
		result = prime * result + id_direccion;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		Direccion_entrega other = (Direccion_entrega) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (codigopostal == null) {
			if (other.codigopostal != null)
				return false;
		} else if (!codigopostal.equals(other.codigopostal))
			return false;
		if (dni_cliente == null) {
			if (other.dni_cliente != null)
				return false;
		} else if (!dni_cliente.equals(other.dni_cliente))
			return false;
		if (id_direccion!= other.id_direccion)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Direcciones_entrega [id_direccionesentrega=" + id_direccion+ ", dni_cliente=" + dni_cliente
				+ ", pais=" + pais + ", provincia=" + provincia + ", ciudad=" + ciudad + ", codigopostal="
				+ codigopostal + ", calle=" + calle + ", numero=" + numero + "]";
	}
	
	
	

	
	
}
