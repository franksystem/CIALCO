package ec.gob.magap.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORGANIZACION_TBL")
public class OrganizacionDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_ORGANIZACION", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_ORGANIZACION_SEQ", sequenceName = "ID_ORGANIZACION_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ORGANIZACION_SEQ")
	private Long idOrganizacion;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGOGRADO")
	private Integer idcatalogoGrado;

	@Column(name = "NOMBREORGANIZACION")
	private String nombreOrganizacion;

	@Column(name = "NOMBREREPRESENTANTE")
	private String nombreRepresentante;

	@Column(name = "TELEFONOREPRESENTANTE")
	private String telefonoRepresentante;

	@Column(name = "MAILREPRESENTANTE")
	private String mailRepresentante;

	@Column(name = "NOMBRECONTACTO")
	private String nombreContacto;

	@Column(name = "TELEFONOCONTACTO")
	private String telefonoContacto;

	@Column(name = "MAILCONTACTO")
	private String mailContacto;

	@Column(name = "NUMERODSOCIOS")
	private Integer numeroDSocios;

	@Column(name = "FECHASEPS")
	private Date fechaSeps;

	@Column(name = "CODIGOSEPS")
	private String codigoSeps;

	@Column(name = "FECHAMAGAP")
	private Date fechaMagap;

	@Column(name = "CODIGOMAGAP")
	private String codigoMagap;

	@Column(name = "SUPERFICIEORG")
	private Double superficieOrg;

	@Column(name = "RUC")
	private Long ruc;

	@Transient
	private String nameGrado;

	@Transient
	private Integer numeroProductores;

	@Transient
	private Integer numeroParticipantes;

	public Long getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public Integer getIdcatalogoGrado() {
		return idcatalogoGrado;
	}

	public void setIdcatalogoGrado(Integer idcatalogoGrado) {
		this.idcatalogoGrado = idcatalogoGrado;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getTelefonoRepresentante() {
		return telefonoRepresentante;
	}

	public void setTelefonoRepresentante(String telefonoRepresentante) {
		this.telefonoRepresentante = telefonoRepresentante;
	}

	public String getMailRepresentante() {
		return mailRepresentante;
	}

	public void setMailRepresentante(String mailRepresentante) {
		this.mailRepresentante = mailRepresentante;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getMailContacto() {
		return mailContacto;
	}

	public void setMailContacto(String mailContacto) {
		this.mailContacto = mailContacto;
	}

	public Integer getNumeroDSocios() {
		return numeroDSocios;
	}

	public void setNumeroDSocios(Integer numeroDSocios) {
		this.numeroDSocios = numeroDSocios;
	}

	public Date getFechaSeps() {
		return fechaSeps;
	}

	public void setFechaSeps(Date fechaSeps) {
		this.fechaSeps = fechaSeps;
	}

	public Date getFechaMagap() {
		return fechaMagap;
	}

	public void setFechaMagap(Date fechaMagap) {
		this.fechaMagap = fechaMagap;
	}

	public Double getSuperficieOrg() {
		return superficieOrg;
	}

	public void setSuperficieOrg(Double superficieOrg) {
		this.superficieOrg = superficieOrg;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public String getNameGrado() {
		return nameGrado;
	}

	public void setNameGrado(String nameGrado) {
		this.nameGrado = nameGrado;
	}

	public String getCodigoSeps() {
		return codigoSeps;
	}

	public void setCodigoSeps(String codigoSeps) {
		this.codigoSeps = codigoSeps;
	}

	public String getCodigoMagap() {
		return codigoMagap;
	}

	public void setCodigoMagap(String codigoMagap) {
		this.codigoMagap = codigoMagap;
	}

	public Long getRuc() {
		return ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}

	public Integer getNumeroProductores() {
		return numeroProductores;
	}

	public void setNumeroProductores(Integer numeroProductores) {
		this.numeroProductores = numeroProductores;
	}

	public Integer getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(Integer numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

}