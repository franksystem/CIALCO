package ec.gob.magap.web.controller.adminusuario;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.web.controller.LoginController;

@ManagedBean(value = "pantallaController")
@ViewScoped
public class MenuController {
	@ManagedProperty(value = "loginController")
	private LoginController loginController;
	
	@ManagedProperty(value="pantallaController")
	private PantallaController pantallaController;
	
	private MenuDTO menuDTO;
	
	public void newMenu() {
		// Creo el objeto e inicializo los datos de auditoria
		menuDTO = new MenuDTO();
		//this.pantallaController.setPantallaDTO(new PantallaDTO());
	}
	/*
	public void guardarForm() {
		try {
			// Recupero la menu
			MenuDTO menuDTO = getMenuDTO();
			// Pregunto si es un registro nuevo o es uno para actualizar
			if (menuDTO.getIdMenu() == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Menú creado correctamente " + menuDTO.getNombre() + "  " +
						menuDTO.getIdMenuPadre() + " " + menuDTO.getPantallaDTO().getIdPantalla() ));
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
							"No se pudo guardar menú"));
			// resetForm();
		}
	}

*/
	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	public PantallaController getPantallaController() {
		return pantallaController;
	}
	public void setPantallaController(PantallaController pantallaController) {
		this.pantallaController = pantallaController;
	}
}
