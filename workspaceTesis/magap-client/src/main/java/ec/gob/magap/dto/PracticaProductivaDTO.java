package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRACTICAPRODUCTIVA_TBL")
public class PracticaProductivaDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PRACTICAPRODUCTIVA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRACTICAPRODUCTIVA_SEQ", sequenceName = "ID_PRACTICAPRODUCTIVA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRACTICAPRODUCTIVA_SEQ")
	private Long idPracticaProductiva;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGOPRACTICAPRODUCTIVA")
	private Integer idCatalogoPracticaProductiva;

	@Column(name = "ID_CATALOGOCERTIFICACION")
	private Integer idCatalogoCertificacion;

	@Column(name = "ID_CATALOGOCERTIFICADORA")
	private Integer idCatalogoCertificadora;

	public Long getIdPracticaProductiva() {
		return idPracticaProductiva;
	}

	public void setIdPracticaProductiva(Long idPracticaProductiva) {
		this.idPracticaProductiva = idPracticaProductiva;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Integer getIdCatalogoPracticaProductiva() {
		return idCatalogoPracticaProductiva;
	}

	public void setIdCatalogoPracticaProductiva(
			Integer idCatalogoPracticaProductiva) {
		this.idCatalogoPracticaProductiva = idCatalogoPracticaProductiva;
	}

	public Integer getIdCatalogoCertificacion() {
		return idCatalogoCertificacion;
	}

	public void setIdCatalogoCertificacion(Integer idCatalogoCertificacion) {
		this.idCatalogoCertificacion = idCatalogoCertificacion;
	}

	public Integer getIdCatalogoCertificadora() {
		return idCatalogoCertificadora;
	}

	public void setIdCatalogoCertificadora(Integer idCatalogoCertificadora) {
		this.idCatalogoCertificadora = idCatalogoCertificadora;
	}

}