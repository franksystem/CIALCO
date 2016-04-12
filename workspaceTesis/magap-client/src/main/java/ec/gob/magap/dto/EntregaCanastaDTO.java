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
@Table(name = "ENTREGACANASTA_TBL")
public class EntregaCanastaDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047131535075209706L;

	@Id
	@Column(name = "ID_ENTREGACANASTA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_ENTREGACANASTA_SEQ", sequenceName = "ID_ENTREGACANASTA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ENTREGACANASTA_SEQ")
	private Long idEntregaCanasta;

	@Column(name = "ID_CANASTA")
	private Long idCanasta;

	@Column(name = "ID_CATALOTIPOCANASTA")
	private Integer idcatalogoTipoEntrega;

	public Long getIdEntregaCanasta() {
		return idEntregaCanasta;
	}

	public void setIdEntregaCanasta(Long idEntregaCanasta) {
		this.idEntregaCanasta = idEntregaCanasta;
	}

	public Long getIdCanasta() {
		return idCanasta;
	}

	public void setIdCanasta(Long idCanasta) {
		this.idCanasta = idCanasta;
	}

	public Integer getIdcatalogoTipoEntrega() {
		return idcatalogoTipoEntrega;
	}

	public void setIdcatalogoTipoEntrega(Integer idcatalogoTipoEntrega) {
		this.idcatalogoTipoEntrega = idcatalogoTipoEntrega;
	}

}
