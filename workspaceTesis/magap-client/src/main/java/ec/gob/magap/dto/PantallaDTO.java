package ec.gob.magap.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "PANTALLA_TBL")
@Proxy(lazy = false)
public class PantallaDTO extends AuditoriaDTO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5950350039287754988L;
	
	//Definicion de atributos
	@Id
	@Column(name = "ID_PANTALLA", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PANTALLA_SEQ", sequenceName = "ID_PANTALLA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PANTALLA_SEQ")
	private Long idPantalla;
	
	@Column(name = "URL")
	private String url;

	@OneToMany(mappedBy = "pantallaDTO")
    private List<MenuDTO> menuDTOs;
	
	@Column(name = "NOMBREPANTALLA")
	private String nombrePantalla;

	//Getters y setters
	public Long getIdPantalla() {
		return idPantalla;
	}

	public void setIdPantalla(Long idPantalla) {
		this.idPantalla = idPantalla;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuDTO> getMenuDTOs() {
		return menuDTOs;
	}

	public void setMenuDTOs(List<MenuDTO> menuDTOs) {
		this.menuDTOs = menuDTOs;
	}

	public String getNombrePantalla() {
		return nombrePantalla;
	}

	public void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
}
