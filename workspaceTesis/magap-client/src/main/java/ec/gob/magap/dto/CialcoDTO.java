package ec.gob.magap.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CIALCO_TBL")
public class CialcoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7179825011344486204L;

	@Id
	@Column(name = "ID_CIALCO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_CIALCO_SEQ", sequenceName = "ID_CIALCO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CIALCO_SEQ")
	private Long idCialco;

	@Column(name = "NOMBRECIALCO")
	private String nombreCialco;

	@Column(name = "NOMBREREPRESENTANTECIALCO")
	private String nombreRepresentanteCialco;

	@Column(name = "TELEFONOFIJO")
	private String telefonoFijo;

	@Column(name = "TELEFONOMOVIL")
	private String telefonoMovil;

	@Column(name = "NOMBREORGANIZACION")
	private String nombreOrganizacion;

	@Column(name = "ID_CATALOGOFRECUENCIA")
	private Integer idCatalogoFrecuencia;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_CATALOGOFRECUENCIA", referencedColumnName = "ID_CATALOGO", insertable = false, updatable = false) })
	private CatalogoDTO frecuenciaDTO;

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

	@Column(name = "LOCALIDAD")
	private String localidad;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "TIPO")
	private Integer tipo;

	@Column(name = "FECHAINICIO")
	private Date fechaIni;

	@Column(name = "FECHAFIN")
	private Date fechaFin;

	@Column(name = "ID_CATALOGODIAS")
	private String idCatalogoDias;

	@Column(name = "MONTOCOMPRAS")
	private Double montoCompras;

	@Column(name = "MONTOVENTAS")
	private Double montoVentas;

	@Transient
	private List<PersonaDTO> personaDTOs;

	@Transient
	private List<ProveedorDTO> proveedorDTOs;

	@Transient
	private List<String> idDias;

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public String getNombreCialco() {
		return nombreCialco;
	}

	public void setNombreCialco(String nombreCialco) {
		this.nombreCialco = nombreCialco;
	}

	public String getNombreRepresentanteCialco() {
		return nombreRepresentanteCialco;
	}

	public void setNombreRepresentanteCialco(String nombreRepresentanteCialco) {
		this.nombreRepresentanteCialco = nombreRepresentanteCialco;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public Integer getIdCatalogoFrecuencia() {
		return idCatalogoFrecuencia;
	}

	public void setIdCatalogoFrecuencia(Integer idCatalogoFrecuencia) {
		this.idCatalogoFrecuencia = idCatalogoFrecuencia;
	}

	public CatalogoDTO getFrecuenciaDTO() {
		return frecuenciaDTO;
	}

	public void setFrecuenciaDTO(CatalogoDTO frecuenciaDTO) {
		this.frecuenciaDTO = frecuenciaDTO;
	}

	public List<PersonaDTO> getPersonaDTOs() {
		return personaDTOs;
	}

	public void setPersonaDTOs(List<PersonaDTO> personaDTOs) {
		this.personaDTOs = personaDTOs;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<ProveedorDTO> getProveedorDTOs() {
		return proveedorDTOs;
	}

	public void setProveedorDTOs(List<ProveedorDTO> proveedorDTOs) {
		this.proveedorDTOs = proveedorDTOs;
	}

	public List<String> getIdDias() {
		return idDias;
	}

	public void setIdDias(List<String> idDias) {
		this.idDias = idDias;
	}

	public String getIdCatalogoDias() {
		return idCatalogoDias;
	}

	public void setIdCatalogoDias(String idCatalogoDias) {
		this.idCatalogoDias = idCatalogoDias;
	}

	public Double getMontoCompras() {
		return montoCompras;
	}

	public void setMontoCompras(Double montoCompras) {
		this.montoCompras = montoCompras;
	}

	public Double getMontoVentas() {
		return montoVentas;
	}

	public void setMontoVentas(Double montoVentas) {
		this.montoVentas = montoVentas;
	}

}