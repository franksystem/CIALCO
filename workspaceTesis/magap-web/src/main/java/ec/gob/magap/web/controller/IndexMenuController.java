package ec.gob.magap.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.factory.MagapFactory;

@ManagedBean(name = "indexMenuController")
@ViewScoped
public class IndexMenuController {
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
	
}
