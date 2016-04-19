package ec.gob.magap.web.controller.adminusuario;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.web.controller.LoginController;

@ManagedBean(value = "pantallaController")
@ViewScoped
public class MenuController {
	@ManagedProperty(value = "loginController")
	private LoginController loginController;
	
	private MenuDTO menuDTO;
	
	public void newMenu() {
		// Creo el objeto e inicializo los datos de auditoria
		menuDTO = new MenuDTO();
		menuDTO.setEstado(Parameter.ESTADO_ACTIVO);
		menuDTO.setIdUsuarioCreacion(loginController.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		menuDTO.setFechaCreacion(new Timestamp(new Date().getTime()));
		setMenuDTO(menuDTO);
	}

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}
	
	
}
