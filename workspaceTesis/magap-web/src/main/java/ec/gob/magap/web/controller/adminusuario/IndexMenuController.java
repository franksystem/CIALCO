package ec.gob.magap.web.controller.adminusuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CommonController;

@ManagedBean(name = "indexMenuController")
@ViewScoped
public class IndexMenuController {

	@ManagedProperty(value = "#{commonController}")
	private CommonController commonController;

	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;

	private MenuDTO menuDTO;
	private PantallaDTO pantallaDTO;
	private List<MenuDTO> menuDTOs;
	private List<MenuDTO> filteredMenuDTOs;
	private List<MenuDTO> filtroMenuPadres;
	
	@PostConstruct
	public void init() {
		this.menuDTO = new MenuDTO();
		if (this.menuDTOs == null) {
			this.menuDTOs = new ArrayList<MenuDTO>();
		}
		if(this.filtroMenuPadres == null){
			this.filtroMenuPadres = new ArrayList<MenuDTO>();
		}
		findMenu();
	}

	public void findMenu() {
		this.menuDTOs = MagapFactory.getInstance().getIMagapService()
				.findMenuDTO(this.menuDTO);
		this.filtroMenuPadres = MagapFactory.getInstance().getIMagapService()
		.findMenuPadreDTO(this.menuDTO);
	}
	

	public void newMenu() {
		this.commonController.menuItem(16);
		this.menuController.newMenu();
	}
	
	public void editarMenu(MenuDTO menuDTO) {
		this.commonController.menuItem(16);
		this.menuController.setMenuDTO(menuDTO);
	}

	public void inactivaMenu(MenuDTO menuDTO){
		this.menuController.setMenuDTO(menuDTO);
		this.menuController.inactivaMenu();
	}
	
	public void guardarForm() {
		this.menuController.guardarForm();
	}

	public void consultarMenu(MenuDTO menuDTO) {
		this.menuController.setMenuDTO(menuDTO);
	}

	public List<MenuDTO> getMenuDTOs() {
		return menuDTOs;
	}

	public void setMenuDTOs(List<MenuDTO> menuDTOs) {
		this.menuDTOs = menuDTOs;
	}

	public List<MenuDTO> getFilteredMenuDTOs() {
		return filteredMenuDTOs;
	}

	public void setFilteredMenuDTOs(List<MenuDTO> filteredMenuDTOs) {
		this.filteredMenuDTOs = filteredMenuDTOs;
	}

	public CommonController getCommonController() {
		return commonController;
	}

	public void setCommonController(CommonController commonController) {
		this.commonController = commonController;
	}

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}

	public List<MenuDTO> getFiltroMenuPadres() {
		return filtroMenuPadres;
	}

	public void setFiltroMenuPadres(List<MenuDTO> filtroMenuPadres) {
		this.filtroMenuPadres = filtroMenuPadres;
	}

	
}
