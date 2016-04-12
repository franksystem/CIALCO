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
@Table(name = "DESTINOINGRESO_TBL")
public class DestinoIngresoDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6853728268755369029L;

	@Id
	@Column(name = "ID_DESTINOINGRESO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_DESTINOINGRESO_SEQ", sequenceName = "ID_DESTINOINGRESO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_DESTINOINGRESO_SEQ")
	private Long idDestinoIngreso;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGODESTINO")
	private Integer idCatalogoDestino;

	public Long getIdDestinoIngreso() {
		return idDestinoIngreso;
	}

	public void setIdDestinoIngreso(Long idDestinoIngreso) {
		this.idDestinoIngreso = idDestinoIngreso;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Integer getIdCatalogoDestino() {
		return idCatalogoDestino;
	}

	public void setIdCatalogoDestino(Integer idCatalogoDestino) {
		this.idCatalogoDestino = idCatalogoDestino;
	}
}
