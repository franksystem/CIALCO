package ec.gob.magap.web.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.magap.dto.UsuarioDTO;

@ManagedBean(name = "sessionUser")
@SessionScoped
public class SessionUser {

	private UsuarioDTO usuarioDTO;

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
