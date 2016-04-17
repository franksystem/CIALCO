package ec.gob.magap.web.controller.adminusuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.MenuDTO;
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
	private List<MenuDTO> menuDTOs;
	private List<MenuDTO> filteredMenuDTOs;

	@PostConstruct
	public void init() {
		this.menuDTO = new MenuDTO();
		if (this.menuDTOs == null) {
			this.menuDTOs = new ArrayList<MenuDTO>();
		}
		findMenu();
	}

	public void findMenu() {
		this.menuDTOs = MagapFactory.getInstance().getIMagapService()
				.findMenuDTO(this.menuDTO);
	}

	public void newMenu(){
		this.commonController.menuItem(16);
		this.menuController.newMenu();
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
	
	
}
