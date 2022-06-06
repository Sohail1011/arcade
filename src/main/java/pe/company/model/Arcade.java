package pe.company.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "arcade")
public class Arcade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer arcadeId;

	@Column(name = "desarrolladora")
	private String desarrolladora;

	@Column(name = "monto")
	private Double monto;

	@Column(name = "activo")
	private String activo;

	@ManyToOne
	@JoinColumn(name = "jefe_id", nullable = false)
	private Jefe jefe;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tecnico_id", nullable = false, unique = true)
	private Tecnico tecnico;

	@ManyToMany
	@JoinTable(name = "arcades_proveedores", 
		joinColumns = @JoinColumn(name = "arcade_id"), 
		inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
	private Set<Proveedor> itemsProveedor = new HashSet<>();

	public Arcade() {
	}

	public Arcade(Integer arcadeId, String desarrolladora, Double monto, String activo) {
		this.arcadeId = arcadeId;
		this.desarrolladora = desarrolladora;
		this.monto = monto;
		this.activo = activo;
	}

	public Integer getArcadeId() {
		return arcadeId;
	}

	public void setArcadeId(Integer arcadeId) {
		this.arcadeId = arcadeId;
	}

	public String getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(String desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public void forEach(Consumer<? super Proveedor> action) {
		itemsProveedor.forEach(action);
	}

	public int size() {
		return itemsProveedor.size();
	}

	public boolean isEmpty() {
		return itemsProveedor.isEmpty();
	}

	public boolean contains(Object o) {
		return itemsProveedor.contains(o);
	}

	public Iterator<Proveedor> iterator() {
		return itemsProveedor.iterator();
	}

	public Object[] toArray() {
		return itemsProveedor.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return itemsProveedor.toArray(a);
	}

	public boolean add(Proveedor e) {
		return itemsProveedor.add(e);
	}

	public boolean remove(Object o) {
		return itemsProveedor.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return itemsProveedor.containsAll(c);
	}

	public boolean addAll(Collection<? extends Proveedor> c) {
		return itemsProveedor.addAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return itemsProveedor.retainAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return itemsProveedor.removeAll(c);
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return itemsProveedor.toArray(generator);
	}

	public void clear() {
		itemsProveedor.clear();
	}

	public boolean equals(Object o) {
		return itemsProveedor.equals(o);
	}

	public int hashCode() {
		return itemsProveedor.hashCode();
	}

	public Spliterator<Proveedor> spliterator() {
		return itemsProveedor.spliterator();
	}

	public boolean removeIf(Predicate<? super Proveedor> filter) {
		return itemsProveedor.removeIf(filter);
	}

	public Stream<Proveedor> stream() {
		return itemsProveedor.stream();
	}

	public Stream<Proveedor> parallelStream() {
		return itemsProveedor.parallelStream();
	}
}
