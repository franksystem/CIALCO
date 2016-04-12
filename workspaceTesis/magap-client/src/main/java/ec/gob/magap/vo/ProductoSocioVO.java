package ec.gob.magap.vo;

import java.util.List;

import ec.gob.magap.dto.PersonaDTO;

public class ProductoSocioVO {

	private PersonaDTO selectedPersonaDTO;
	private List<String> idProdSocio;
	private Boolean selected;

	public PersonaDTO getSelectedPersonaDTO() {
		return selectedPersonaDTO;
	}

	public void setSelectedPersonaDTO(PersonaDTO selectedPersonaDTO) {
		this.selectedPersonaDTO = selectedPersonaDTO;
	}

	public List<String> getIdProdSocio() {
		return idProdSocio;
	}

	public void setIdProdSocio(List<String> idProdSocio) {
		this.idProdSocio = idProdSocio;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
