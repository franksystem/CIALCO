package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_TBL")
public class ProductoDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PRODUCTO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRODUCTO_SEQ", sequenceName = "ID_PRODUCTO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCTO_SEQ")
	private Long idProducto;

	@Column(name = "NOMBREPRODUCTO")
	private String nombreProducto;

	@Column(name = "ID_CATALOGOTIPOPRODUCTO")
	private Integer idCatalogoTipoProducto;

	@Column(name = "ID_CATALOGORUBRO")
	private Integer idCatalogoRubro;

	@Column(name = "ID_CATALOGOUNIDAD")
	private Integer idCatalogoUnidad;

	@Column(name = "ID_CATALOGOPRESENTACION")
	private Integer idCatalogoPresentacion;

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getIdCatalogoTipoProducto() {
		return idCatalogoTipoProducto;
	}

	public void setIdCatalogoTipoProducto(Integer idCatalogoTipoProducto) {
		this.idCatalogoTipoProducto = idCatalogoTipoProducto;
	}

	public Integer getIdCatalogoRubro() {
		return idCatalogoRubro;
	}

	public void setIdCatalogoRubro(Integer idCatalogoRubro) {
		this.idCatalogoRubro = idCatalogoRubro;
	}

	public Integer getIdCatalogoUnidad() {
		return idCatalogoUnidad;
	}

	public void setIdCatalogoUnidad(Integer idCatalogoUnidad) {
		this.idCatalogoUnidad = idCatalogoUnidad;
	}

	public Integer getIdCatalogoPresentacion() {
		return idCatalogoPresentacion;
	}

	public void setIdCatalogoPresentacion(Integer idCatalogoPresentacion) {
		this.idCatalogoPresentacion = idCatalogoPresentacion;
	}
}