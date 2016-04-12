package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PARROQUIA_TBL")
public class ParroquiaDTO {

	@Id
	@Column(name = "ID_PARROQUIA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PARROQUIA_SEQ", sequenceName = "ID_PARROQUIA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PARROQUIA_SEQ")
	private Integer idParroquia;

	@Column(name = "NOMBREPARROQUIA")
	private String nombreParroquia;

	@Column(name = "ID_CANTON")
	private Integer idCanton;

	public String getNombreParroquia() {
		return nombreParroquia;
	}

	public void setNombreParroquia(String nombreParroquia) {
		this.nombreParroquia = nombreParroquia;
	}

	public Integer getIdParroquia() {
		return idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
	}

	public Integer getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

}