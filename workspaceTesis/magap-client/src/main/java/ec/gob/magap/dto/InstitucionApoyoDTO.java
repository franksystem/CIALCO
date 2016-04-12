package ec.gob.magap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INSTITUCIONAPOYO_TBL")
public class InstitucionApoyoDTO extends AuditoriaDTO {

	@Id
	@Column(name = "ID_INSTITUCIONAPOYO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_INSTITUCIONAPOYO_SEQ", sequenceName = "ID_INSTITUCIONAPOYO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_INSTITUCIONAPOYO_SEQ")
	private Long idInstitucionApoyo;

	@Column(name = "TIPOAPOYO")
	private String tipoApoyo;

	@Column(name = "NOMBREINSTITUCIONAPOYO")
	private String nombreInstitucionApoyo;

	@Column(name = "ID_PRODUCTOR")
	private Long idProductor;

	public Long getIdInstitucionApoyo() {
		return idInstitucionApoyo;
	}

	public void setIdInstitucionApoyo(Long idInstitucionApoyo) {
		this.idInstitucionApoyo = idInstitucionApoyo;
	}

	public String getTipoApoyo() {
		return tipoApoyo;
	}

	public void setTipoApoyo(String tipoApoyo) {
		this.tipoApoyo = tipoApoyo;
	}

	public String getNombreInstitucionApoyo() {
		return nombreInstitucionApoyo;
	}

	public void setNombreInstitucionApoyo(String nombreInstitucionApoyo) {
		this.nombreInstitucionApoyo = nombreInstitucionApoyo;
	}

	public Long getIdProductor() {
		return idProductor;
	}

	public void setIdProductor(Long idProductor) {
		this.idProductor = idProductor;
	}
}