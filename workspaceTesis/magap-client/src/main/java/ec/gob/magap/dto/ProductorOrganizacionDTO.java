package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTORXORGANIZACION_TBL")
public class ProductorOrganizacionDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PRODUCTORORG", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PRODUCTORORG_SEQ", sequenceName = "ID_PRODUCTORORG_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCTORORG_SEQ")
	private Long idProductorOrg;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	@Column(name = "ID_ORGANIZACION")
	private Long idOrganizacion;

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}

	public Long getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public Long getIdProductorOrg() {
		return idProductorOrg;
	}

	public void setIdProductorOrg(Long idProductorOrg) {
		this.idProductorOrg = idProductorOrg;
	}

}