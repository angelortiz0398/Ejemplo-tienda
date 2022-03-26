package entidades;

import java.io.Serializable;


import org.hibernate.annotations.Entity;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * The persistent class for the categoria database table.
 * 
 */
@SuppressWarnings("deprecation")
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcategoria;

	private String descripcion;

	private byte estado;

	private String nombre;

	//bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy="categoria")
	private List<Articulo> articulos;

	public Categoria() {
	}

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo addArticulo(Articulo articulo) {
		getArticulos().add(articulo);
		articulo.setCategoria(this);

		return articulo;
	}

	public Articulo removeArticulo(Articulo articulo) {
		getArticulos().remove(articulo);
		articulo.setCategoria(null);

		return articulo;
	}

}