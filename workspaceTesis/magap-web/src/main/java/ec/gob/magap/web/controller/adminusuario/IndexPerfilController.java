package ec.gob.magap.web.controller.adminusuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PerfilDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CommonController;

@ManagedBean(name = "indexPerfilController")
@ViewScoped
public class IndexPerfilController {

	@ManagedProperty(value = "#{commonController}")
	private CommonController commonController;

	@ManagedProperty(value = "#{perfilController}")
	private PerfilController perfilController;

	private PerfilDTO perfilDTO;
	private List<PerfilDTO> perfilDTOs;
	private List<PerfilDTO> filteredPerfilDTOs;

	@PostConstruct
	public void init() {
		this.perfilDTO = new PerfilDTO();
		if (this.perfilDTOs == null) {
			this.perfilDTOs = new ArrayList<PerfilDTO>();
		}
		findPerfil();
	}

	public void findPerfil() {
		this.perfilDTOs = MagapFactory.getInstance().getIMagapService()
				.findPerfilDTO(this.perfilDTO);
	}
	
	public void newPerfil() {
		this.commonController.menuItem(17);
		this.perfilController.newPerfil();
	}

	public void consultarPerfil(PerfilDTO perfilDTO) {
		this.perfilController.setPerfilDTO(perfilDTO);
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	public List<PerfilDTO> getPerfilDTOs() {
		return perfilDTOs;
	}

	public void setPerfilDTOs(List<PerfilDTO> perfilDTOs) {
		this.perfilDTOs = perfilDTOs;
	}

	public List<PerfilDTO> getFilteredPerfilDTOs() {
		return filteredPerfilDTOs;
	}

	public void setFilteredPerfilDTOs(List<PerfilDTO> filteredPerfilDTOs) {
		this.filteredPerfilDTOs = filteredPerfilDTOs;
	}

	public PerfilController getPerfilController() {
		return perfilController;
	}

	public void setPerfilController(PerfilController perfilController) {
		this.perfilController = perfilController;
	}

	public CommonController getCommonController() {
		return commonController;
	}

	public void setCommonController(CommonController commonController) {
		this.commonController = commonController;
	}
}
