package ec.gob.magap.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "MENU_TBL")
@Proxy(lazy = false)
public class MenuDTO extends AuditoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3316050465377550016L;

	@Id
	@Column(name = "ID_MENU", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_MENU_SEQ", sequenceName = "ID_MENU_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MENU_SEQ")
	private Long idMenu;

	@Column(name = "ID_MENUPADRE")
	private Long idMenuPadre;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "ID_PANTALLA")
	private Long idPantalla;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_PANTALLA", referencedColumnName = "ID_PANTALLA", insertable = false, updatable = false) })
	private PantallaDTO pantallaDTO;

	@Column(name = "ICONO")
	private String icono;

	@Transient
	private List<MenuDTO> menuHijaDTOs;

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public Long getIdMenuPadre() {
		return idMenuPadre;
	}

	public void setIdMenuPadre(Long idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public List<MenuDTO> getMenuHijaDTOs() {
		return menuHijaDTOs;
	}

	public void setMenuHijaDTOs(List<MenuDTO> menuHijaDTOs) {
		this.menuHijaDTOs = menuHijaDTOs;
	}

	public Long getIdPantalla() {
		return idPantalla;
	}

	public void setIdPantalla(Long idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	
}
