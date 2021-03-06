package ec.gob.magap.web.controller.adminusuario;

import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.PerfilDTO;
import ec.gob.magap.web.controller.LoginController;

@ManagedBean(name = "perfilController")
@ViewScoped
public class PerfilController {
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;

	private PerfilDTO perfilDTO;
	
	public void newPerfil() {
		// Creo el objeto e inicializo los datos de auditoria
		perfilDTO = new PerfilDTO();
		perfilDTO.setEstado(Parameter.ESTADO_ACTIVO);
		perfilDTO.setIdUsuarioCreacion(loginController.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		perfilDTO.setFechaCreacion(new Timestamp(new Date().getTime()));
		setPerfilDTO(perfilDTO);
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void guardarForm(){
		
	}
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}
	
	
}
