package pe.company.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator;

@Entity
@Table(name = "jefe")
public class Jefe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jefeId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "fcontrato")
	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fcontrato;
	
	@OneToMany(mappedBy = "jefe")
	private Collection<Arcade> itemsArcade = new ArrayList();
	
	public Jefe() {
	}

	public Jefe(Integer jefeId, String nombre, String apellido, LocalDate fcontrato) {
		this.jefeId = jefeId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fcontrato = fcontrato;
	}

	public Integer getJefeId() {
		return jefeId;
	}

	public void setJefeId(Integer jefeId) {
		this.jefeId = jefeId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFcontrato() {
		return fcontrato;
	}

	public void setFcontrato(LocalDate fcontrato) {
		this.fcontrato = fcontrato;
	}
}
