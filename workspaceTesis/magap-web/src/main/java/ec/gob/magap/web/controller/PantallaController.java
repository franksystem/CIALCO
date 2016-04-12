package ec.gob.magap.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.PantallaVO;
import ec.gob.magap.web.controller.common.PageController;

@ManagedBean(name = "pantallaController")
@ViewScoped
public class PantallaController {
	@ManagedProperty(value = "#{pageController}")
	private PageController pageController;
	
	public void newPantalla() {
		PantallaDTO pantallaDTO = new PantallaDTO();
		this.pageController.setPantallaDTO(pantallaDTO);
	}

	public void guardarForm() {
		try {
			
			
			//Creacion de variable de instancia
			PantallaVO pantallaVO = new PantallaVO();
			//Cargo el nuevo registro pantallaDTO
			pantallaVO.setPantallaDTO(this.pageController.getPantallaDTO());
			if (pantallaVO.getPantallaDTO().getIdPantalla() == null){
			//Grabo el objeto
			MagapFactory.getInstance().getIMagapService()
					.transSavePantalla(pantallaVO);
			}else{
				//Actualizo el objeto
				MagapFactory.getInstance().getIMagapService()
						.transUpdatePantalla(pantallaVO);
			}
			

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Pantalla guardada correctamente" ));//+ pantallaVO.getPantallaDTO().getNombrePantalla() + pantallaVO.getPantallaDTO().getUrl()));
			resetForm();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"No se pudo guardar la pantalla" + e.toString()));
			resetForm();
		}
	}

	private void resetForm() {
		this.pageController.resetForm();
	}

	public PageController getPageController() {
		return pageController;
	}

	public void setPageController(PageController pageController) {
		this.pageController = pageController;
	}
	
	
}
