package ec.gob.magap.web.controller.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PantallaDTO;

@ManagedBean(name = "menuController")
@ViewScoped

public class MenuController {
	@ManagedProperty(value = "#{pageController}")
	private PageController pageController;
	
	public void newPantalla() {
		PantallaDTO pantallaDTO = new PantallaDTO();
		this.pageController.setPantallaDTO(pantallaDTO);
	}
}
