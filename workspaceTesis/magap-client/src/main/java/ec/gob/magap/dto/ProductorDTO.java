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
@Table(name = "PRODUCTOR_TBL")
public class ProductorDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8754259758031183648L;

	@Id
	@Column(name = "ID_PRODUCTOR", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRODUCTOR_SEQ", sequenceName = "ID_PRODUCTOR_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCTOR_SEQ")
	private Long idProductor;

	@Column(name = "ID_PERSONA")
	private Long idPersona;

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

}