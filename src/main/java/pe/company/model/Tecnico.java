package pe.company.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tecnicoId;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fcontrato")
	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fcontranto;
	
	@Column(name = "sueldo")
	private Double sueldo;
	
	@OneToOne(mappedBy = "tecnico")
	private Arcade arcade;

	public Tecnico() {
	}

	public Tecnico(Integer tecnicoId, String nombre, LocalDate fcontranto, Double sueldo) {
		this.tecnicoId = tecnicoId;
		this.nombre = nombre;
		this.fcontranto = fcontranto;
		this.sueldo = sueldo;
	}

	public Integer getTecnicoId() {
		return tecnicoId;
	}

	public void setTecnicoId(Integer tecnicoId) {
		this.tecnicoId = tecnicoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFcontranto() {
		return fcontranto;
	}

	public void setFcontranto(LocalDate fcontranto) {
		this.fcontranto = fcontranto;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
}
