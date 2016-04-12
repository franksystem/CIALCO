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
@Table(name = "UBICACIONFINCA_TBL")
public class UbicacionFincaDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_UBICACIONFINCA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_UBICACIONFINCA_SEQ", sequenceName = "ID_UBICACIONFINCA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_UBICACIONFINCA_SEQ")
	private Long idUbicacionFinca;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_PROVINCIA")
	private Integer idProvincia;

	@Column(name = "ID_CANTON")
	private Integer idCanton;

	@Column(name = "ID_PARROQUIA")
	private Integer idParroquia;

	@Column(name = "COORDENADAX")
	private Long cordenadaX;

	@Column(name = "COORDENADAY")
	private Long cordenadaY;

	@Column(name = "COORDENADAZ")
	private Long cordenadaZ;

	@Column(name = "LOCALIDADFINCA")
	private String localidadFinca;

	@Column(name = "SUPERFICIEFINCA")
	private Double superficieFinca;

	@Column(name = "OTRA")
	private String otra;

	@Column(name = "ID_CATALOGOPOSESION")
	private Integer idCatalogoPosesion;

	@Transient
	private String simbolo;

	public Long getIdUbicacionFinca() {
		return idUbicacionFinca;
	}

	public void setIdUbicacionFinca(Long idUbicacionFinca) {
		this.idUbicacionFinca = idUbicacionFinca;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Integer getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	public Integer getIdParroquia() {
		return idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
	}

	public Long getCordenadaX() {
		return cordenadaX;
	}

	public void setCordenadaX(Long cordenadaX) {
		this.cordenadaX = cordenadaX;
	}

	public Long getCordenadaY() {
		return cordenadaY;
	}

	public void setCordenadaY(Long cordenadaY) {
		this.cordenadaY = cordenadaY;
	}

	public Long getCordenadaZ() {
		return cordenadaZ;
	}

	public void setCordenadaZ(Long cordenadaZ) {
		this.cordenadaZ = cordenadaZ;
	}

	public String getLocalidadFinca() {
		return localidadFinca;
	}

	public void setLocalidadFinca(String localidadFinca) {
		this.localidadFinca = localidadFinca;
	}

	public Double getSuperficieFinca() {
		return superficieFinca;
	}

	public void setSuperficieFinca(Double superficieFinca) {
		this.superficieFinca = superficieFinca;
	}

	public String getOtra() {
		return otra;
	}

	public void setOtra(String otra) {
		this.otra = otra;
	}

	public Integer getIdCatalogoPosesion() {
		return idCatalogoPosesion;
	}

	public void setIdCatalogoPosesion(Integer idCatalogoPosesion) {
		this.idCatalogoPosesion = idCatalogoPosesion;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}