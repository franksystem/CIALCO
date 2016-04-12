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
@Table(name = "DESTINOPRODUCCION_TBL")
public class DestinoProduccionDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1998998164625955381L;

	@Id
	@Column(name = "ID_DESTINOPRODUCCION", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_DESTINOPRODUCCION_SEQ", sequenceName = "ID_DESTINOPRODUCCION_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_DESTINOPRODUCCION_SEQ")
	private Long idDestinoProduccion;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_CATALOGOTIPODESTINO")
	private Integer idCatalogoTipoDestino;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	public Long getIdDestinoProduccion() {
		return idDestinoProduccion;
	}

	public void setIdDestinoProduccion(Long idDestinoProduccion) {
		this.idDestinoProduccion = idDestinoProduccion;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Integer getIdCatalogoTipoDestino() {
		return idCatalogoTipoDestino;
	}

	public void setIdCatalogoTipoDestino(Integer idCatalogoTipoDestino) {
		this.idCatalogoTipoDestino = idCatalogoTipoDestino;
	}

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}
}