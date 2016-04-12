package ec.gob.magap.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class AuditoriaDTO {

	public AuditoriaDTO() {
		super();
	}

	@Column(name = "ESTADO")
	private Integer estado;

	@Column(name = "ID_USUARIOCREACION")
	private Long idUsuarioCreacion;

	@Column(name = "FECHACREACION")
	private Timestamp fechaCreacion;

	@Column(name = "ID_USUARIOMODIFICACION")
	private Long idUsuarioModificacion;

	@Column(name = "FECHAMODIFICACION")
	private Timestamp fechaModificacion;

	@Transient
	private Boolean selected;

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Long getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Long idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(Long idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
