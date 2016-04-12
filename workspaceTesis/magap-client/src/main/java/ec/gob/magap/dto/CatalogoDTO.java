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
@Table(name = "CATALOGO_TBL")
public class CatalogoDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3538461790344249084L;

	@Id
	@Column(name = "ID_CATALOGO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_CATALOGO_SEQ", sequenceName = "ID_CATALOGO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CATALOGO_SEQ")
	private Integer idCatalogo;

	@Column(name = "TIPOCATALOGO")
	private Integer tipoCatalogo;

	@Column(name = "ELEMENTOCATALOGO")
	private String elementoCatalogo;

	@Column(name = "DESCRIPCIONCATALOGO")
	private String descripcionCatalogo;

	@Column(name = "ID_CATALOGOPADRE")
	private Integer idCatalogoPadre;

	public Integer getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public Integer getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(Integer tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}

	public String getElementoCatalogo() {
		return elementoCatalogo;
	}

	public void setElementoCatalogo(String elementoCatalogo) {
		this.elementoCatalogo = elementoCatalogo;
	}

	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}

	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}

	public Integer getIdCatalogoPadre() {
		return idCatalogoPadre;
	}

	public void setIdCatalogoPadre(Integer idCatalogoPadre) {
		this.idCatalogoPadre = idCatalogoPadre;
	}
}