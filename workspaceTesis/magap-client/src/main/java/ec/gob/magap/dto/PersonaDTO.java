package ec.gob.magap.dto;

import java.io.Serializable;

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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "PERSONA_TBL")
@Proxy (lazy = false)
public class PersonaDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -158808248954436045L;

	/**
	 * 
	 */

	@Id
	@Column(name = "ID_PERSONA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PERSONA_SEQ", sequenceName = "ID_PERSONA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PERSONA_SEQ")
	private Long idPersona;

	@Column(name = "NOMBREPERSONA")
	private String nombrePersona;

	@Column(name = "APELLIDOPERSONA")
	private String apellidoPersona;

	@Column(name = "CEDULAPERSONA")
	private Long cedulaPersona;

	@Column(name = "EDADPERSONA")
	private Integer edadPersona;

	@Column(name = "MAILPERSONA")
	private String mailPersona;

	@Column(name = "ACTIVIDADPERSONA")
	private String actividadPersona;

	@Column(name = "ID_CATALOGOGENERO")
	private Integer idCatalogoGenero;

	@Column(name = "ID_CATALOGOETNIA")
	private Integer idCatalogoEtnia;

	@Column(name = "ID_CATALOGOESCOLARIDAD")
	private Integer idCatalogoEscolaridad;

	@Column(name = "ID_CATALOGOPARENTESCO")
	private Integer idCatalogoParentesco;

	@Column(name = "TELEFONOFIJO")
	private String telefonoFijo;

	@Column(name = "TELEFONOMOVIL")
	private String telefonoMovil;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false) })
	private ProductorDTO productorDTO;
	
	@Transient
	private String parentesco;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public Long getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(Long cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public Integer getEdadPersona() {
		return edadPersona;
	}

	public void setEdadPersona(Integer edadPersona) {
		this.edadPersona = edadPersona;
	}

	public String getMailPersona() {
		return mailPersona;
	}

	public void setMailPersona(String mailPersona) {
		this.mailPersona = mailPersona;
	}

	public String getActividadPersona() {
		return actividadPersona;
	}

	public void setActividadPersona(String actividadPersona) {
		this.actividadPersona = actividadPersona;
	}

	public Integer getIdCatalogoGenero() {
		return idCatalogoGenero;
	}

	public void setIdCatalogoGenero(Integer idCatalogoGenero) {
		this.idCatalogoGenero = idCatalogoGenero;
	}

	public Integer getIdCatalogoEtnia() {
		return idCatalogoEtnia;
	}

	public void setIdCatalogoEtnia(Integer idCatalogoEtnia) {
		this.idCatalogoEtnia = idCatalogoEtnia;
	}

	public Integer getIdCatalogoEscolaridad() {
		return idCatalogoEscolaridad;
	}

	public void setIdCatalogoEscolaridad(Integer idCatalogoEscolaridad) {
		this.idCatalogoEscolaridad = idCatalogoEscolaridad;
	}

	public Integer getIdCatalogoParentesco() {
		return idCatalogoParentesco;
	}

	public void setIdCatalogoParentesco(Integer idCatalogoParentesco) {
		this.idCatalogoParentesco = idCatalogoParentesco;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public ProductorDTO getProductorDTO() {
		return productorDTO;
	}

	public void setProductorDTO(ProductorDTO productorDTO) {
		this.productorDTO = productorDTO;
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
}
