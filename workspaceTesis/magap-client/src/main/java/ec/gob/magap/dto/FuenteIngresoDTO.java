package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FUENTEINGRESO_TBL")
public class FuenteIngresoDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_FUENTEINGRESO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_FUENTEINGRESO_SEQ", sequenceName = "ID_FUENTEINGRESO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_FUENTEINGRESO_SEQ")
	private Long idFuenteIngreso;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGOTIPOFUENTE")
	private Integer idCatalogoTipoFuente;

	public Long getIdFuenteIngreso() {
		return idFuenteIngreso;
	}

	public void setIdFuenteIngreso(Long idFuenteIngreso) {
		this.idFuenteIngreso = idFuenteIngreso;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Integer getIdCatalogoTipoFuente() {
		return idCatalogoTipoFuente;
	}

	public void setIdCatalogoTipoFuente(Integer idCatalogoTipoFuente) {
		this.idCatalogoTipoFuente = idCatalogoTipoFuente;
	}
}