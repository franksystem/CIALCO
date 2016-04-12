package ec.gob.magap.web.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.BooleanUtils;

import ec.gob.magap.dto.InstitucionApoyoDTO;

@ManagedBean(name = "supportController")
@ViewScoped
public class SupportController {

	private InstitucionApoyoDTO institucionApoyoDTO;
	private ArrayList<InstitucionApoyoDTO> institucionApoyoDTOs;
	private List<InstitucionApoyoDTO> deleteInstitucionApoyoDTOs;

	@PostConstruct
	public void init() {
		if (this.institucionApoyoDTOs == null) {
			this.institucionApoyoDTOs = new ArrayList<InstitucionApoyoDTO>();
		}
		if (this.deleteInstitucionApoyoDTOs == null) {
			this.deleteInstitucionApoyoDTOs = new ArrayList<InstitucionApoyoDTO>();
		}
	}

	public void resetForm() {
		this.institucionApoyoDTO = new InstitucionApoyoDTO();
		this.institucionApoyoDTOs = new ArrayList<InstitucionApoyoDTO>();
		this.deleteInstitucionApoyoDTOs = new ArrayList<InstitucionApoyoDTO>();
	}

	public void newIntitucion() {
		this.institucionApoyoDTO = new InstitucionApoyoDTO();
	}

	public void addInstitucion() {
		if (!BooleanUtils.toBoolean(this.institucionApoyoDTO.getSelected())) {
			this.institucionApoyoDTOs.add(this.institucionApoyoDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Institucion agregada correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Institucion editada correctamente"));
		}
		this.institucionApoyoDTO.setSelected(Boolean.TRUE);
		this.institucionApoyoDTO = new InstitucionApoyoDTO();
	}

	public void deleteInstitucion(InstitucionApoyoDTO institucionApoyoDTO) {
		if (institucionApoyoDTO.getIdInstitucionApoyo() != null) {
			this.deleteInstitucionApoyoDTOs.add(institucionApoyoDTO);
		}
		this.institucionApoyoDTOs.remove(institucionApoyoDTO);
	}

	public InstitucionApoyoDTO getInstitucionApoyoDTO() {
		return institucionApoyoDTO;
	}

	public void setInstitucionApoyoDTO(InstitucionApoyoDTO institucionApoyoDTO) {
		this.institucionApoyoDTO = institucionApoyoDTO;
	}

	public ArrayList<InstitucionApoyoDTO> getInstitucionApoyoDTOs() {
		return institucionApoyoDTOs;
	}

	public void setInstitucionApoyoDTOs(
			ArrayList<InstitucionApoyoDTO> institucionApoyoDTOs) {
		this.institucionApoyoDTOs = institucionApoyoDTOs;
	}

	public List<InstitucionApoyoDTO> getDeleteInstitucionApoyoDTOs() {
		return deleteInstitucionApoyoDTOs;
	}

	public void setDeleteInstitucionApoyoDTOs(
			List<InstitucionApoyoDTO> deleteInstitucionApoyoDTOs) {
		this.deleteInstitucionApoyoDTOs = deleteInstitucionApoyoDTOs;
	}

}
