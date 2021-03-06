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
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "USUARIO_TBL")
@Proxy (lazy = false)
public class UsuarioDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 2923730392886464654L;

	@Id
	@Column(name = "ID_USUARIO", nullable = false, insertable = true, updatable = false, columnDefinition = "NUMBER")
	@SequenceGenerator(name = "ID_USUARIO_SEQ", sequenceName = "ID_USUARIO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO_SEQ")
	private Long idUsuario;

	@Column(name = "ID_PERSONA")
	private Long idPersona;

	@Column(name = "NOMBREUSUARIO")
	private String nombreUsuario;

	@Column(name = "CONTRASENA")
	private String contrasena;

	//Cambio FJBL 28-03-2016
	/*@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL", insertable = false, updatable = false) })
	private PerfilDTO perfilDTO;*/

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	@OneToMany(mappedBy="usuarioDTO", fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<UsuarioPerfilDTO> usuarioPerfilDTOs;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false) })
	private PersonaDTO personaDTO;

   
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<UsuarioPerfilDTO> getUsuarioPerfilDTOs() {
		return usuarioPerfilDTOs;
	}

	public void setUsuarioPerfilDTOs(List<UsuarioPerfilDTO> usuarioPerfilDTOs) {
		this.usuarioPerfilDTOs = usuarioPerfilDTOs;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	/*public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

/*	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}*/
	/*
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public UsuarioDTO() {
		super();
	}

	public List<UsuarioPerfilDTO> getUsuarioPerfilDTOs() {
		return usuarioPerfilDTOs;
	}

	public void setUsuarioPerfilDTOs(List<UsuarioPerfilDTO> usuarioPerfilDTOs) {
		this.usuarioPerfilDTOs = usuarioPerfilDTOs;
	}
	*/
    
	
}