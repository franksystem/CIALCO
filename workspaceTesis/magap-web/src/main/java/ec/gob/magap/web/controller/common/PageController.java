package ec.gob.magap.web.controller.common;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PantallaDTO;

@ManagedBean(name = "pageController")
@ViewScoped
public class PageController {
	private PantallaDTO pantallaDTO;
	
	@PostConstruct
	public void init() {
		if (this.pantallaDTO == null) {
			this.pantallaDTO = new PantallaDTO();
		}
	}

	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}
	
	public void resetForm() {
		this.pantallaDTO = new PantallaDTO();
	}
	
}
