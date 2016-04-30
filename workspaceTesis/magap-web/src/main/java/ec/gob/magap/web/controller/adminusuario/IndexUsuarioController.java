package ec.gob.magap.web.controller.adminusuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.factory.MagapFactory;

@ManagedBean(name = "indexUsuarioController")
@ViewScoped
public class IndexUsuarioController {
	@ManagedProperty(value = "#{usuarioController}")
	private UsuarioController usuarioController;

	private PersonaDTO personaDTO;
	private List<PersonaDTO> personaDTOs;
	private List<PersonaDTO> filteredPersonaDTOs;

	@PostConstruct
	public void init() {
		this.personaDTO = new PersonaDTO();
		if (this.personaDTOs == null) {
			this.personaDTOs = new ArrayList<PersonaDTO>();
		}
		findUsuario();
	}

	public void findUsuario() {
		this.personaDTOs = MagapFactory.getInstance().getIMagapService()
				.findUsuario(this.personaDTO);
	}

	public void consultarUsuario(PersonaDTO personaDTO) {
		this.usuarioController.setPersonaDTO(personaDTO);
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public List<PersonaDTO> getPersonaDTOs() {
		return personaDTOs;
	}

	public void setPersonaDTOs(List<PersonaDTO> personaDTOs) {
		this.personaDTOs = personaDTOs;
	}

	public List<PersonaDTO> getFilteredPersonaDTOs() {
		return filteredPersonaDTOs;
	}

	public void setFilteredPersonaDTOs(List<PersonaDTO> filteredPersonaDTOs) {
		this.filteredPersonaDTOs = filteredPersonaDTOs;
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}
}
