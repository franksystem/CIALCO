package ec.gob.magap.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.dto.UsuarioDTO;
import ec.gob.magap.exception.MagapException;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.manager.SessionUser;

@ManagedBean(name = "loginController")
@ViewScoped
public class LoginController {

	@ManagedProperty(value = "#{sessionUser}")
	private SessionUser sessionUser;

	private String userName;
	private String password;

	@PostConstruct
	public void init() {
		System.out.println("loginController");
	}

	public void loginUser() {
		try {
			// Verificación si las variables estan vacias retorna mensaje
			if (StringUtils.isBlank(this.userName)
					|| StringUtils.isBlank(this.password)) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Por favor ingrese su información de loggin"));
				return;
			}

			// Variable de instancia que es llamado en una interface
			// IMagapService al metodo login
			UsuarioDTO usuarioDTO = MagapFactory.getInstance()
					.getIMagapService().login(this.userName, this.password);

			// Si es nulo retorna mensaje
			if (usuarioDTO == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Nombre de usuario o contrasena incorrectos"));
				return;
			}

			// Agrego la sesion y redirecciono a la pagina
			try {
				this.sessionUser.setUsuarioDTO(usuarioDTO);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().redirect("../magap-web-0.0.1-SNAPSHOT/pages/private/index.jsf");
			} catch (Exception e1) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"no se pudo redireccionar a la pagina"));
				throw new MagapException(e1);
			}
			/*
			 * FacesContext .getCurrentInstance() .getExternalContext()
			 * .redirect("../magap-web-0.0.1-SNAPSHOT/pages/private/index.jsf");
			 */

		} catch (Exception e) {
			MagapLogger.log.error("loginUser {}", e);
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
									"Manejo de error: Por favor cuminicarse con el administrador del sistema"));
			throw new MagapException(e);
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SessionUser getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(SessionUser sessionUser) {
		this.sessionUser = sessionUser;
	}

}
