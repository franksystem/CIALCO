package ec.gob.magap.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PROVEEDOR_TBL")
public class ProveedorDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_PROVEEDOR", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PROVEEDOR_SEQ", sequenceName = "ID_PROVEEDOR_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PROVEEDOR_SEQ")
	private Long idProveevor;

	@Column(name = "ID_CIALCO")
	private Long idCialco;

	@Column(name = "NOMBREPROVEEDOR")
	private String nombreProveedor;

	@Column(name = "TELEFONOFIJO")
	private String telefonoFijo;

	@Column(name = "TELEFONOMOVIL")
	private String telefonoMovil;

	@Column(name = "ID_CATALOGORUBROS")
	private String idCatalogoRubros;

	@Column(name = "CORREO")
	private String correo;

	@Transient
	private String rubro;

	@Transient
	private List<String> idRubrosOfrece;

	public Long getIdProveevor() {
		return idProveevor;
	}

	public void setIdProveevor(Long idProveevor) {
		this.idProveevor = idProveevor;
	}

	public Long getIdCialco() {
		return idCialco;
	}

	public void setIdCialco(Long idCialco) {
		this.idCialco = idCialco;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getIdCatalogoRubros() {
		return idCatalogoRubros;
	}

	public void setIdCatalogoRubros(String idCatalogoRubros) {
		this.idCatalogoRubros = idCatalogoRubros;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<String> getIdRubrosOfrece() {
		return idRubrosOfrece;
	}

	public void setIdRubrosOfrece(List<String> idRubrosOfrece) {
		this.idRubrosOfrece = idRubrosOfrece;
	}

}
