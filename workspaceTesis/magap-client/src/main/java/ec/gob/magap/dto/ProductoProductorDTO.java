package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Embeddable
@Table(name = "PRODUCTOXPRODUCTOR_TBL")
public class ProductoProductorDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PRODUCTPRO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRODUCTPRO_SEQ", sequenceName = "ID_PRODUCTPRO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCTPRO_SEQ")
	private Long idProductoPro;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGOPRODUCTO")
	private Integer idCatalogoProducto;

	@Column(name = "ID_CATALOGOTIPOPRO")
	private Integer idCatalogoTipoPro;

	@Column(name = "ID_CATALOGORUBROPRO")
	private Integer idCatalogoRubroPro;

	@Column(name = "ID_CATALOGOUNIDAD")
	private Integer idCatalogoUnidad;

	@Column(name = "TIPO")
	private Integer tipo;

	@Transient
	private String nombreTipoPro;

	@Transient
	private String nombreRubroPro;

	@Transient
	private String nombrePro;

	@Transient
	private Boolean type = Boolean.FALSE;

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Long getIdProductoPro() {
		return idProductoPro;
	}

	public void setIdProductoPro(Long idProductoPro) {
		this.idProductoPro = idProductoPro;
	}

	public Integer getIdCatalogoTipoPro() {
		return idCatalogoTipoPro;
	}

	public void setIdCatalogoTipoPro(Integer idCatalogoTipoPro) {
		this.idCatalogoTipoPro = idCatalogoTipoPro;
	}

	public Integer getIdCatalogoProducto() {
		return idCatalogoProducto;
	}

	public void setIdCatalogoProducto(Integer idCatalogoProducto) {
		this.idCatalogoProducto = idCatalogoProducto;
	}

	public Integer getIdCatalogoRubroPro() {
		return idCatalogoRubroPro;
	}

	public void setIdCatalogoRubroPro(Integer idCatalogoRubroPro) {
		this.idCatalogoRubroPro = idCatalogoRubroPro;
	}

	public Integer getIdCatalogoUnidad() {
		return idCatalogoUnidad;
	}

	public void setIdCatalogoUnidad(Integer idCatalogoUnidad) {
		this.idCatalogoUnidad = idCatalogoUnidad;
	}

	public String getNombreTipoPro() {
		return nombreTipoPro;
	}

	public void setNombreTipoPro(String nombreTipoPro) {
		this.nombreTipoPro = nombreTipoPro;
	}

	public String getNombreRubroPro() {
		return nombreRubroPro;
	}

	public void setNombreRubroPro(String nombreRubroPro) {
		this.nombreRubroPro = nombreRubroPro;
	}

	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}