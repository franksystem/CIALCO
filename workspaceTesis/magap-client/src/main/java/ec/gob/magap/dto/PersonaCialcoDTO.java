package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONASXCIALCO_TBL")
public class PersonaCialcoDTO {

	@Id
	@Column(name = "ID_PERSONACIALCO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PERSONACIALCO_SEQ", sequenceName = "ID_PERSONACIALCO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PERSONACIALCO_SEQ")
	private Long idPersonaCialco;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	@Column(name = "ID_PERSONA")
	private Long idPersona;

	public Long getIdPersonaCialco() {
		return idPersonaCialco;
	}

	public void setIdPersonaCialco(Long idPersonaCialco) {
		this.idPersonaCialco = idPersonaCialco;
	}

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

}
