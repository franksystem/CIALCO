package ec.gob.magap.web.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.BooleanUtils;

import ec.gob.magap.dto.OrganizacionDTO;

@ManagedBean(name = "orgController")
@ViewScoped
public class OrgController {

	private OrganizacionDTO organizacionDTO;
	private List<OrganizacionDTO> organizacionDTOs;
	private String tipoDocumento;

	@PostConstruct
	public void init() {
		newOrganizacion();
	}

	public void newOrganizacion() {
		this.setOrganizacionDTO(new OrganizacionDTO());
		this.setOrganizacionDTOs(new ArrayList<OrganizacionDTO>());
		this.tipoDocumento = "1";
	}

	public void deleteOrg(OrganizacionDTO organizacionDTO) {
		this.organizacionDTOs.remove(organizacionDTO);
	}

	public void addOrg() {
		if (!BooleanUtils.toBoolean(this.organizacionDTO.getSelected())) {
			this.organizacionDTOs.add(this.organizacionDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Organizacion agregada correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Organizacion editada correctamente"));
		}
		this.organizacionDTO.setSelected(Boolean.TRUE);
		setOrganizacionDTO(new OrganizacionDTO());
	}

	public OrganizacionDTO getOrganizacionDTO() {
		return organizacionDTO;
	}

	public void setOrganizacionDTO(OrganizacionDTO organizacionDTO) {
		this.organizacionDTO = organizacionDTO;
	}

	public List<OrganizacionDTO> getOrganizacionDTOs() {
		return organizacionDTOs;
	}

	public void setOrganizacionDTOs(List<OrganizacionDTO> organizacionDTOs) {
		this.organizacionDTOs = organizacionDTOs;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}