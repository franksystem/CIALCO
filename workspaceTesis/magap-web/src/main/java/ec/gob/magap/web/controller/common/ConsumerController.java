package ec.gob.magap.web.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.inputtext.InputText;

import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.util.CedulaValidatorUtil;

@ManagedBean(name = "consumerController")
@ViewScoped
public class ConsumerController {

	private PersonaDTO personaDTO;
	private List<PersonaDTO> personaDTOs;

	@PostConstruct
	public void init() {
		if (this.personaDTOs == null) {
			this.personaDTOs = new ArrayList<PersonaDTO>();
		}
	}

	public void newConsumer() {
		this.personaDTO = new PersonaDTO();
	}

	public void resetConsumer() {
		this.personaDTO = new PersonaDTO();
		this.personaDTOs = new ArrayList<PersonaDTO>();
	}

	public void addConsumidor() {

		Boolean valid = Boolean.TRUE;
		String cedula = this.personaDTO.getCedulaPersona().toString();
		if (StringUtils.isNotBlank(cedula)
				&& CedulaValidatorUtil.validateCedula(cedula)) {

			if (!BooleanUtils.toBoolean(this.personaDTO.getSelected())) {
				this.personaDTOs.add(this.personaDTO);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Consumidor agregado correctamente"));
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Consumidor editado correctamente"));
			}
			this.personaDTO.setSelected(Boolean.TRUE);
			this.setPersonaDTO(new PersonaDTO());

		} else {
			valid = Boolean.FALSE;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"El n\u00FAmero de c\u00E9dula no es v\u00E1lido"));
		}
		UIComponent component = (UIComponent) FacesContext.getCurrentInstance()
				.getViewRoot().findComponent("page:formConsu:idced");
		if (component != null) {
			((HtmlInputText) component).setValid(valid);
		}

	}

	public void findPersona() {
		Boolean valid = Boolean.TRUE;
		String cedula = this.personaDTO.getCedulaPersona().toString();
		if (StringUtils.isNotBlank(cedula)
				&& CedulaValidatorUtil.validateCedula(cedula)) {
			PersonaDTO person = MagapFactory.getInstance().getIMagapService()
					.findPersonaByCedula(this.personaDTO.getCedulaPersona());
			if (person != null && person.getIdPersona() != null) {
				this.personaDTO = person;
			}
		} else {
			valid = Boolean.FALSE;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"El n\u00FAmero de c\u00E9dula no es v\u00E1lido"));
		}
		UIComponent component = (UIComponent) FacesContext.getCurrentInstance()
				.getViewRoot().findComponent("page:formConsu:idced");
		if (component != null) {
			((InputText) component).setValid(valid);
		}
	}

	public void deleteConsumer(PersonaDTO personaDTO) {
		this.personaDTOs.remove(personaDTO);
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public List<PersonaDTO> getPersonaDTOs() {
		return personaDTOs;
	}

	public void setPersonaDTOs(List<PersonaDTO> personaDTOs) {
		this.personaDTOs = personaDTOs;
	}
}