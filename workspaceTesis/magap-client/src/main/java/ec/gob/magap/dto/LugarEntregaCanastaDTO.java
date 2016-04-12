package ec.gob.magap.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LUGARENTREGACANASTA_TBL")
public class LugarEntregaCanastaDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_LUGARENTREGACANASTA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_LUGARENTREGACANASTA_SEQ", sequenceName = "ID_LUGARENTREGACANASTA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_LUGARENTREGACANASTA_SEQ")
	private Long idLugarEntregaCanasta;

	@Column(name = "ID_ENTREGACANASTA")
	private Long idEntregaCanasta;

	@Column(name = "ID_CATALOFRECUENCIA")
	private Integer idcatalogoFrecuencia;

	@Column(name = "ID_CATALOGOsDIAS")
	private String idcatalogoDias;

	@Column(name = "LUGAR")
	private String lugar;

	@Transient
	private String nameFrecuencia;

	@Transient
	private String nameDias;

	@Transient
	private List<String> idDias;

	@Transient
	private List<String> idRubros;

	@Transient
	private Double precio;

	@Transient
	private Integer numeroCanasta;

	@Transient
	private String nombreCanasta;

	public Long getIdLugarEntregaCanasta() {
		return idLugarEntregaCanasta;
	}

	public void setIdLugarEntregaCanasta(Long idLugarEntregaCanasta) {
		this.idLugarEntregaCanasta = idLugarEntregaCanasta;
	}

	public Long getIdEntregaCanasta() {
		return idEntregaCanasta;
	}

	public void setIdEntregaCanasta(Long idEntregaCanasta) {
		this.idEntregaCanasta = idEntregaCanasta;
	}

	public Integer getIdcatalogoFrecuencia() {
		return idcatalogoFrecuencia;
	}

	public void setIdcatalogoFrecuencia(Integer idcatalogoFrecuencia) {
		this.idcatalogoFrecuencia = idcatalogoFrecuencia;
	}

	public String getIdcatalogoDias() {
		return idcatalogoDias;
	}

	public void setIdcatalogoDias(String idcatalogoDias) {
		this.idcatalogoDias = idcatalogoDias;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNameFrecuencia() {
		return nameFrecuencia;
	}

	public void setNameFrecuencia(String nameFrecuencia) {
		this.nameFrecuencia = nameFrecuencia;
	}

	public String getNameDias() {
		return nameDias;
	}

	public void setNameDias(String nameDias) {
		this.nameDias = nameDias;
	}

	public List<String> getIdDias() {
		return idDias;
	}

	public void setIdDias(List<String> idDias) {
		this.idDias = idDias;
	}

	public List<String> getIdRubros() {
		return idRubros;
	}

	public void setIdRubros(List<String> idRubros) {
		this.idRubros = idRubros;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getNumeroCanasta() {
		return numeroCanasta;
	}

	public void setNumeroCanasta(Integer numeroCanasta) {
		this.numeroCanasta = numeroCanasta;
	}

	public String getNombreCanasta() {
		return nombreCanasta;
	}

	public void setNombreCanasta(String nombreCanasta) {
		this.nombreCanasta = nombreCanasta;
	}

}
