package ec.gob.magap.web.controller.adminusuario;

import java.sql.Timestamp;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.LoginController;

@ManagedBean(name = "menuController")
@ViewScoped
public class MenuController {
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;

	private MenuDTO menuDTO;
	private PantallaDTO pantallaDTO;

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public void newMenu() {
		// Creo el objeto e inicializo los datos de auditoria
		menuDTO = new MenuDTO();
		menuDTO.setEstado(Parameter.ESTADO_ACTIVO);
		menuDTO.setIdUsuarioCreacion(loginController.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		menuDTO.setFechaCreacion(new Timestamp(new Date().getTime()));
		setMenuDTO(menuDTO);
	}
	
	public void guardarForm(){
		try {
			// Recupero el menu
			MenuDTO menuDTO = getMenuDTO();
			
			// Pregunto si es un registro nuevo o es uno para actualizar
			if (menuDTO.getIdMenu() == null ) {
				MagapFactory.getInstance().getIMagapService()
						.transSaveMenu(menuDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Menú creado correctamente"));
				//resetForm();
			} else {
				// Actualizo el registro
				menuDTO.setIdUsuarioModificacion(loginController
						.getSessionUser().getUsuarioDTO().getIdUsuario());
				menuDTO.setFechaModificacion(new Timestamp(new Date()
						.getTime()));

				MagapFactory.getInstance().getIMagapService()
						.transSaveMenu(menuDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Menú actualizado correctamente"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"No se pudo guardar el menú" + e));
			// resetForm();
		}
	}
	
	public void inactivaMenu(){
		try {
			// Recupero el menu
			MenuDTO menuDTO = getMenuDTO();
			if (menuDTO.getIdMenu() != null ) {
				// Actualizo el registro
				menuDTO.setIdUsuarioModificacion(loginController
						.getSessionUser().getUsuarioDTO().getIdUsuario());
				menuDTO.setFechaModificacion(new Timestamp(new Date()
						.getTime()));
				menuDTO.setEstado(Parameter.ESTADO_INACTIVO);
				
				MagapFactory.getInstance().getIMagapService()
						.transSaveMenu(menuDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Menú inactivado correctamente"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"No se pudo guardar el menú" + e));
			// resetForm();
		}
	}

}
