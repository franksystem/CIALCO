package ec.gob.magap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.factory.MagapFactory;

@ManagedBean(name = "indexCialcoController")
@ViewScoped
public class IndexCialcoController {

	private CialcoDTO cialcoDTO;
	private List<CialcoDTO> cialcoDTOs;
	private List<CialcoDTO> filterCialcoDTOs;
	
	@PostConstruct
	public void init() {
		this.cialcoDTO = new CialcoDTO();
		if (this.cialcoDTOs == null) {
			this.cialcoDTOs = new ArrayList<CialcoDTO>();
		}
		findCialco();
	}

	public void findCialco() {
		this.cialcoDTOs = MagapFactory.getInstance().getIMagapService()
				.findCialcoDTO(this.cialcoDTO);
	}

	
	
	public CialcoDTO getCialcoDTO() {
		return cialcoDTO;
	}
	public void setCialcoDTO(CialcoDTO cialcoDTO) {
		this.cialcoDTO = cialcoDTO;
	}
	public List<CialcoDTO> getCialcoDTOs() {
		return cialcoDTOs;
	}
	public void setCialcoDTOs(List<CialcoDTO> cialcoDTOs) {
		this.cialcoDTOs = cialcoDTOs;
	}
	public List<CialcoDTO> getFilterCialcoDTOs() {
		return filterCialcoDTOs;
	}
	public void setFilterCialcoDTOs(List<CialcoDTO> filterCialcoDTOs) {
		this.filterCialcoDTOs = filterCialcoDTOs;
	}
}
