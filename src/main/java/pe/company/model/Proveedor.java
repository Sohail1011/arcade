package pe.company.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proveedorId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "pais")
	private String pais;

	@Column(name = "fcontrato")
	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fcontrato;

	@ManyToMany(mappedBy = "itemsProveedor")
	private Set<Arcade> itemsArcade = new HashSet<>();

	public Proveedor() {
	}

	public Proveedor(Integer proveedorId, String nombre, String pais, LocalDate fcontrato) {
		this.proveedorId = proveedorId;
		this.nombre = nombre;
		this.pais = pais;
		this.fcontrato = fcontrato;
	}

	public Integer getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDate getFcontrato() {
		return fcontrato;
	}

	public void setFcontrato(LocalDate fcontrato) {
		this.fcontrato = fcontrato;
	}

	public Set<Arcade> getItemsArcade() {
		return itemsArcade;
	}

	public void setItemsArcade(Set<Arcade> itemsArcade) {
		this.itemsArcade = itemsArcade;
	}
}
