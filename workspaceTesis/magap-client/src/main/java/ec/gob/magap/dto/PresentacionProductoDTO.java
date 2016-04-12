package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRESENTACIONPRODUCTO_TBL")
public class PresentacionProductoDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PRESENTACIONPRODUCTO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRESENTACIONPRODUCTO_SEQ", sequenceName = "ID_PRESENTACIONPRODUCTO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRESENTACIONPRODUCTO_SEQ")
	private Long idPresentacionProducto;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	@Column(name = "ID_CATALOGOPRODUCTO")
	private Integer idCatalogoProducto;

	@Column(name = "ID_CATALOGOPRESENTACION")
	private Integer idCatalogoPresentacion;

	@Column(name = "CANTIDAD")
	private Integer cantidad;

	@Column(name = "ID_CATALOGOUNIDAD")
	private Integer idCatalogoUnidad;

	@Column(name = "PRECIO")
	private Double precio;

	@Column(name = "MONTOMES")
	private Double montoMes;

	@Transient
	private String nombreProducto;

	@Transient
	private String nombrePresentacion;

	@Transient
	private String nombreUnidad;
	@Transient
	private Double volumenVendido;
	@Transient
	private Double volumenOfertado;

	public Long getIdPresentacionProducto() {
		return idPresentacionProducto;
	}

	public void setIdPresentacionProducto(Long idPresentacionProducto) {
		this.idPresentacionProducto = idPresentacionProducto;
	}

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public Integer getIdCatalogoProducto() {
		return idCatalogoProducto;
	}

	public void setIdCatalogoProducto(Integer idCatalogoProducto) {
		this.idCatalogoProducto = idCatalogoProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdCatalogoUnidad() {
		return idCatalogoUnidad;
	}

	public void setIdCatalogoUnidad(Integer idCatalogoUnidad) {
		this.idCatalogoUnidad = idCatalogoUnidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getIdCatalogoPresentacion() {
		return idCatalogoPresentacion;
	}

	public void setIdCatalogoPresentacion(Integer idCatalogoPresentacion) {
		this.idCatalogoPresentacion = idCatalogoPresentacion;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombrePresentacion() {
		return nombrePresentacion;
	}

	public void setNombrePresentacion(String nombrePresentacion) {
		this.nombrePresentacion = nombrePresentacion;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public Double getMontoMes() {
		return montoMes;
	}

	public void setMontoMes(Double montoMes) {
		this.montoMes = montoMes;
	}

	public Double getVolumenVendido() {
		return volumenVendido;
	}

	public void setVolumenVendido(Double volumenVendido) {
		this.volumenVendido = volumenVendido;
	}

	public Double getVolumenOfertado() {
		return volumenOfertado;
	}

	public void setVolumenOfertado(Double volumenOfertado) {
		this.volumenOfertado = volumenOfertado;
	}

}
