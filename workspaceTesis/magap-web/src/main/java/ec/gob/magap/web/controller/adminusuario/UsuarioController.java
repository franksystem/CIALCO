package ec.gob.magap.web.controller.adminusuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PersonaDTO;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController {
	private PersonaDTO personaDTO;

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}
}
