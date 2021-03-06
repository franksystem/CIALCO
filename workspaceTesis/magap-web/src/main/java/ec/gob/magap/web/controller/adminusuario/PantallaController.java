package ec.gob.magap.web.controller.adminusuario;

import java.sql.Timestamp;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.LoginController;

@ManagedBean(name = "pantallaController")
@ViewScoped
public class PantallaController {
	 
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;

	private PantallaDTO pantallaDTO;

	public void newPantalla() {
		// Creo el objeto e inicializo los datos de auditoria
		pantallaDTO = new PantallaDTO();
		pantallaDTO.setEstado(Parameter.ESTADO_ACTIVO);
		pantallaDTO.setIdUsuarioCreacion(loginController.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		pantallaDTO.setFechaCreacion(new Timestamp(new Date().getTime()));
		setPantallaDTO(pantallaDTO);
	}

	public void guardarForm() {
		try {
			// Recupero la pantalla
			PantallaDTO pantallaDTO = getPantallaDTO();
			// Pregunto si es un registro nuevo o es uno para actualizar
			if (pantallaDTO.getIdPantalla() == null) {
				MagapFactory.getInstance().getIMagapService()
						.transSavePantalla(pantallaDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Pantalla creada correctamente"));
				resetForm();
			} else {
				// Actualizo el registro
				pantallaDTO.setIdUsuarioModificacion(loginController
						.getSessionUser().getUsuarioDTO().getIdUsuario());
				pantallaDTO.setFechaModificacion(new Timestamp(new Date()
						.getTime()));

				MagapFactory.getInstance().getIMagapService()
						.transSavePantalla(pantallaDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Pantalla actualizada correctamente"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"No se pudo guardar la pantalla" + e.toString()));
			// resetForm();
		}
	}

	public void inactivaPantallaDTO() {
		try {
			// Recupero la pantalla
			PantallaDTO pantallaDTO = getPantallaDTO();
			// Pregunto si es un registro nuevo o es uno para actualizar
			if (pantallaDTO.getIdPantalla() != null) {
				// Actualizo el registro
				pantallaDTO.setEstado(Parameter.ESTADO_INACTIVO);
				pantallaDTO.setIdUsuarioModificacion(loginController
						.getSessionUser().getUsuarioDTO().getIdUsuario());
				pantallaDTO.setFechaModificacion(new Timestamp(new Date()
						.getTime()));

				MagapFactory.getInstance().getIMagapService()
						.transSavePantalla(pantallaDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Pantalla inactivada correctamente"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"No se pudo guardar la pantalla" + e.toString()));
			// resetForm();
		}
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

	private void resetForm() {
		pantallaDTO = new PantallaDTO();
		pantallaDTO.setEstado(Parameter.ESTADO_ACTIVO);
		pantallaDTO.setIdUsuarioCreacion(loginController.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		pantallaDTO.setFechaCreacion(new Timestamp(new Date().getTime()));
		setPantallaDTO(pantallaDTO);
	}	
}
