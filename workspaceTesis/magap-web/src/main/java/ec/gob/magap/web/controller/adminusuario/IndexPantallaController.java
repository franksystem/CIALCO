package ec.gob.magap.web.controller.adminusuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CommonController;

@ManagedBean(name = "indexPantallaController")
@ViewScoped
public class IndexPantallaController {
	@ManagedProperty(value = "#{commonController}")
	private CommonController commonController;

	@ManagedProperty(value = "#{pantallaController}")
	private PantallaController pantallaController;

	private PantallaDTO pantallaDTO;
	private List<PantallaDTO> pantallaDTOs;
	private List<PantallaDTO> filteredPantallaDTOs;

	@PostConstruct
	public void init() {
		this.pantallaDTO = new PantallaDTO();
		if (this.pantallaDTOs == null) {
			this.pantallaDTOs = new ArrayList<PantallaDTO>();
		}
		findPantalla();
	}

	public void findPantalla() {
		this.pantallaDTOs = MagapFactory.getInstance().getIMagapService()
				.findPantallaDTO(this.pantallaDTO);
	}

	public void newPantalla() {
		this.commonController.menuItem(15);
		this.pantallaController.newPantalla();
	}

	public void editPantalla(PantallaDTO pantallaDTO) {
		this.commonController.menuItem(15);
		this.pantallaController.setPantallaDTO(pantallaDTO);
	}
	
	public void inactivaPantalla(PantallaDTO pantallaDTO){
		this.pantallaController.setPantallaDTO(pantallaDTO);
		this.pantallaController.inactivaPantallaDTO();
	}
	
	public void consultarPantalla(PantallaDTO pantallaDTO) {
		this.pantallaController.setPantallaDTO(pantallaDTO);
	}
	
	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}

	public List<PantallaDTO> getPantallaDTOs() {
		return pantallaDTOs;
	}

	public void setPantallaDTOs(List<PantallaDTO> pantallaDTOs) {
		this.pantallaDTOs = pantallaDTOs;
	}

	public CommonController getCommonController() {
		return commonController;
	}

	public void setCommonController(CommonController commonController) {
		this.commonController = commonController;
	}

	public PantallaController getPantallaController() {
		return pantallaController;
	}

	public void setPantallaController(PantallaController pantallaController) {
		this.pantallaController = pantallaController;
	}

	public List<PantallaDTO> getFilteredPantallaDTOs() {
		return filteredPantallaDTOs;
	}

	public void setFilteredPantallaDTOs(List<PantallaDTO> filteredPantallaDTOs) {
		this.filteredPantallaDTOs = filteredPantallaDTOs;
	}

}
