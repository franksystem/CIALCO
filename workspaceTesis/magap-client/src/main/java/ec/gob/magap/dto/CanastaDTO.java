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
@Table(name = "CANASTA_TBL")
public class CanastaDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 883692909052863333L;

	@Id
	@Column(name = "ID_CANASTA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_CANASTA_SEQ", sequenceName = "ID_CANASTA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CANASTA_SEQ")
	private Long idCanasta;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	@Column(name = "ID_CATALOTIPOCANASTA")
	private Integer idcatalogoTipoCanasta;

	@Column(name = "PRECIOCANASTA")
	private Double precioCanasta;

	public Long getIdCanasta() {
		return idCanasta;
	}

	public void setIdCanasta(Long idCanasta) {
		this.idCanasta = idCanasta;
	}

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public Integer getIdcatalogoTipoCanasta() {
		return idcatalogoTipoCanasta;
	}

	public void setIdcatalogoTipoCanasta(Integer idcatalogoTipoCanasta) {
		this.idcatalogoTipoCanasta = idcatalogoTipoCanasta;
	}

	public Double getPrecioCanasta() {
		return precioCanasta;
	}

	public void setPrecioCanasta(Double precioCanasta) {
		this.precioCanasta = precioCanasta;
	}

}
