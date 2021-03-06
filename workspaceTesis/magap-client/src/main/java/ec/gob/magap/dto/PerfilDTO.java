package ec.gob.magap.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "PERFIL_TBL")
@Proxy(lazy = false)
public class PerfilDTO extends AuditoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2387527762306905584L;

	@Id
	@Column(name = "ID_PERFIL", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_PERFIL_SEQ", sequenceName = "ID_PERFIL_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PERFIL_SEQ")
	private Long idPerfil;

	@Column(name = "ID_MENU")
	private Long idMenu;

	@Column(name = "NOMBREPERFIL")
	private String nombrePerfil;

	@Column(name = "DESCRIPCIONPERFIL")
	private String descripcionPerfil;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU", insertable = false, updatable = false) })
	private MenuDTO menuDTO;

	//FJBL 28-03-2016
	/*@ManyToMany(mappedBy="perfilDTOs")
	private List<UsuarioDTO> UsuarioDTOs;*/
	
	@OneToMany(mappedBy="perfilDTO", fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<UsuarioPerfilDTO> usuarioPerfilDTOs;
	
	@Transient
	private List<MenuDTO> menuDTOs;

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public List<MenuDTO> getMenuDTOs() {
		return menuDTOs;
	}

	public void setMenuDTOs(List<MenuDTO> menuDTOs) {
		this.menuDTOs = menuDTOs;
	}

	public List<UsuarioPerfilDTO> getUsuarioPerfilDTOs() {
		return usuarioPerfilDTOs;
	}

	public void setUsuarioPerfilDTOs(List<UsuarioPerfilDTO> usuarioPerfilDTOs) {
		this.usuarioPerfilDTOs = usuarioPerfilDTOs;
	}

	
}