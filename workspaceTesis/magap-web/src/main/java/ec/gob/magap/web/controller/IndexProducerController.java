package ec.gob.magap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CommonController;

@ManagedBean(name = "indexProducerController")
@ViewScoped
public class IndexProducerController {

	@ManagedProperty(value = "#{commonController}")
	private CommonController commonController;

	@ManagedProperty(value = "#{producerController}")
	private ProducerController producerController;

	private PersonaDTO personaDTO;
	private List<PersonaDTO> personaDTOs;

	@PostConstruct
	public void init() {
		this.personaDTO = new PersonaDTO();
		if (this.personaDTOs == null) {
			this.personaDTOs = new ArrayList<PersonaDTO>();
		}
	}

	public void findProducer() {
		this.personaDTOs = MagapFactory.getInstance().getIMagapService()
				.findProductor(this.personaDTO);
	}

	public void newProducer() {
		this.commonController.menuItem(2);
		this.producerController.newProductor();
	}

	public void editProducer(PersonaDTO personaDTO) {
		this.commonController.menuItem(2);
		this.producerController.getPersonController().setPersonaDTO(personaDTO);
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

	public ProducerController getProducerController() {
		return producerController;
	}

	public void setProducerController(ProducerController producerController) {
		this.producerController = producerController;
	}

	public CommonController getCommonController() {
		return commonController;
	}

	public void setCommonController(CommonController commonController) {
		this.commonController = commonController;
	}

}
