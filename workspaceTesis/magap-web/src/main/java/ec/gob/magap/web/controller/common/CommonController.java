package ec.gob.magap.web.controller.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.dto.UsuarioPerfilDTO;
import ec.gob.magap.web.manager.SessionUser;

@ManagedBean(name = "commonController")
@SessionScoped
public class CommonController {

	@ManagedProperty(value = "#{sessionUser}")
	private SessionUser sessionUser;
	private String nombreApellido = "";
	private MenuModel model;
	private String form = "magapController";
	private String url;
	private UsuarioPerfilDTO usuarioPerfilDTO;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		// Fjbl 28-03-2016
		List<UsuarioPerfilDTO> usuarioPerfilDTO = this.sessionUser
				.getUsuarioDTO().getUsuarioPerfilDTOs();
		for (Iterator<UsuarioPerfilDTO> it = usuarioPerfilDTO.iterator(); it
				.hasNext();) {
			this.usuarioPerfilDTO = it.next();
		}

		if (this.usuarioPerfilDTO.getPerfilDTO().getMenuDTOs() != null) {

			for (MenuDTO menuDTO : this.usuarioPerfilDTO.getPerfilDTO()
					.getMenuDTOs()) {
				if (menuDTO.getIdMenuPadre() == null) {
					DefaultSubMenu mainMenu = new DefaultSubMenu(
							menuDTO.getNombre());

					if (menuDTO.getMenuHijaDTOs() != null) {
						List<MenuElement> elements = loadMenuHijas(menuDTO
								.getMenuHijaDTOs());
						mainMenu.setElements(elements);
						model.addElement(mainMenu);
					}

				}
			}

		}

		this.nombreApellido = this.sessionUser
				.getUsuarioDTO()
				.getPersonaDTO()
				.getNombrePersona()
				.concat(" ")
				.concat(this.sessionUser.getUsuarioDTO().getPersonaDTO()
						.getApellidoPersona());
	}

	private List<MenuElement> loadMenuHijas(List<MenuDTO> menuHijaDTOs) {
		List<MenuElement> results = new ArrayList<>();
		if (menuHijaDTOs != null && !menuHijaDTOs.isEmpty()) {
			for (MenuDTO menuDTO : menuHijaDTOs) {
				MagapLogger.log.info(menuDTO.getNombre());

				if (menuDTO.getIcono() == null || menuDTO.getIcono().isEmpty()) {
					DefaultSubMenu menuPadre = new DefaultSubMenu(
							menuDTO.getNombre());
					menuPadre.setElements(loadMenuHijas(menuDTO
							.getMenuHijaDTOs()));
					model.addElement(menuPadre);

				} else {
					results.add(loadMenuItem(menuDTO));
				}
			}
		}
		return results;
	}

	private DefaultMenuItem loadMenuItem(MenuDTO menuDTO) {
		DefaultMenuItem item = new DefaultMenuItem(menuDTO.getNombre());
		String url = menuDTO.getPantallaDTO().getUrl().toString();
		StringBuilder sb = new StringBuilder();
		sb.append("#{commonController.loadURL('").append(url).append("')}");
		item.setCommand(sb.toString());
		/*
		 * item.setCommand("#{commonController.loadURL('".concat(url)
		 * .concat("')}"));
		 */

		item.setIcon(menuDTO.getIcono());
		item.setUpdate("@form");
		item.setProcess("@this");
		item.setPartialSubmit(true);
		item.setGlobal(true);
		return item;
	}

	public void loadURL(String url) {
		this.url = url;
	}

	public void menuItem(Integer op) {
		MagapLogger.log.info("{}", op);

		switch (op) {
		case 1:
			url = "/pages/private/indexProducer.xhtml";
			break;
		case 2:
			url = "/pages/private/producer.xhtml";
			break;
		case 3:
			url = "/pages/private/store.xhtml";
			break;
		case 4:
			url = "/pages/private/store.xhtml";
			break;
		case 5:
			url = "/pages/private/footPage.xhtml";
			break;
		case 6:
			url = "/pages/private/footPage.xhtml";
			break;
		case 7:
			url = "/pages/private/hamper.xhtml";
			break;
		case 8:
			url = "/pages/private/hamper.xhtml";
			break;
		case 9:
			url = "/pages/private/fair.xhtml";
			break;
		case 10:
			url = "/pages/private/fair.xhtml";
			break;
		case 11:
			url = "/pages/private/organization.xhtml";
			break;
		case 12:
			url = "/pages/private/organization.xhtml";
			break;
		case 13:
			url = "/pages/private/report/producerReport.xhtml";
			break;
		case 14:
			url = "/pages/private/producer.xhtml";
			break;
		case 15:
			url = "/pages/private/administracionusuario/page.xhtml";
			break;
		case 16:
			url = "/pages/private/administracionusuario/menu.xhtml";
			break;
		case 17:
			url = "/pages/private/administracionusuario/perfil.xhtml";
			break;
			
		default:
			url = "/pages/private/index.xhtml";
			break;
		}
	}

	public void logout() {
		try {
			setSessionUser(null);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/magap-web-0.0.1-SNAPSHOT/index.jsf");// "../index.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SessionUser getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(SessionUser sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

}