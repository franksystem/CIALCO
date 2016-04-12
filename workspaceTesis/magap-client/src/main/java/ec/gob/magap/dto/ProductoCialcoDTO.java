package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOXCIALCO_TBL")
public class ProductoCialcoDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PROCIAL", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PROCIAL_SEQ", sequenceName = "ID_PROCIAL_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PROCIAL_SEQ")
	private Long idProductoCialco;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	@Column(name = "ID_CATALOGOPRODUCTO")
	private Long idCatalogoProducto;

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public Long getIdCatalogoProducto() {
		return idCatalogoProducto;
	}

	public void setIdCatalogoProducto(Long idCatalogoProducto) {
		this.idCatalogoProducto = idCatalogoProducto;
	}

	public Long getIdProductoCialco() {
		return idProductoCialco;
	}

	public void setIdProductoCialco(Long idProductoCialco) {
		this.idProductoCialco = idProductoCialco;
	}

}