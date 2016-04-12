package ec.gob.magap.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CANTON_TBL")
public class CantonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4802450906985843371L;

	@Id
	@Column(name = "ID_CANTON", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_CANTON_SEQ", sequenceName = "ID_CANTON_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CANTON_SEQ")
	private Integer idCanton;

	@Column(name = "ID_PROVINCIA")
	private Integer idProvincia;

	@Column(name = "NOMBRECANTON")
	private String nombreCanton;

	public Integer getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreCanton() {
		return nombreCanton;
	}

	public void setNombreCanton(String nombreCanton) {
		this.nombreCanton = nombreCanton;
	}
}
